
create or replace function
    get_request_etp(v_lot_id bigint, v_from_doc_date DATE, v_to_doc_date DATE,
                    v_organ_name character varying, v_from_sum_lot bigint, v_to_sum_lot bigint,
                    v_month integer, v_state integer, v_pltf integer, v_limit integer, v_offset integer) returns text
    language plpgsql
as
$$
Declare
    r        record;
    dataJson jsonb := '[]';
BEGIN

    for r in SELECT re.id,
                    re.lot_id,
                    re.doc_date,
                    mpd.name   as "organ_name",
                    re.sumlot as "sum_lot",
                    re.month,
                    ra.state,
                    re.pltf
             FROM request_etp re
                      LEFT JOIN response_auction ra
                                ON re.lot_id = ra.lot_id
                      LEFT JOIN man_organizations$payload$data mpd
                                ON mpd.organ = re.organ
             WHERE (re.lot_id = v_lot_id OR v_lot_id = 9223372036854775807)
               AND (re.doc_date BETWEEN v_from_doc_date AND v_to_doc_date)
               AND (mpd.name = v_organ_name OR v_organ_name = 'ALL')
               AND (re.sumlot BETWEEN v_from_sum_lot AND v_to_sum_lot)
               AND (re.month = v_month OR v_month = 2147483647)
               AND (ra.state = v_state OR v_state = 2147483647)
               AND (re.pltf = v_pltf) /* AND ra.state = 2 */ LIMIT v_limit OFFSET v_limit * (v_offset-1)
        loop
            dataJson = dataJson ||  jsonb_agg(r);
        end loop;
    return dataJson::text;
END;
$$;

