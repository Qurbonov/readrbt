create or replace function
    get_claim_info(v_lot_id bigint, v_organ_name character varying,
                   v_from_summa bigint, v_to_summa bigint, v_srok integer,
                   v_state integer, v_proc_id integer) returns text
    language plpgsql
as
$$
Declare
    r        record;
    dataJson jsonb := '[]';
BEGIN

    for r in SELECT cm.id,
                    cm.lot_id,
                    mpd.name as "organ_name",
                    cm.summa,
                    cm.srok,
                    cm.purpose,
                    rcm.state,
                    cm.proc_id,
                    cm.inn,
                    cm.date1,
                    cm.date2,
                    cm.dvr
             FROM claim_info_etp cm
                      LEFT JOIN response_claim_info rcm
                                ON rcm.lot_id = cm.lot_id
                      LEFT JOIN man_organizations$payload$data mpd
                                ON mpd.organ = cm.organ
             WHERE (cm.lot_id = v_lot_id OR v_lot_id = 9223372036854775807)
               AND (mpd.name = v_organ_name OR v_organ_name = 'ALL')
               AND (cm.summa between v_from_summa and v_to_summa)
               AND (cm.srok = v_srok OR v_srok = 2147483647)
               AND (rcm.state = v_state OR v_state = 2147483647)
               AND (cm.proc_id = v_proc_id)
        loop
            dataJson = dataJson || jsonb_agg(r);
        end loop;
    return dataJson::text;
END;
$$;

