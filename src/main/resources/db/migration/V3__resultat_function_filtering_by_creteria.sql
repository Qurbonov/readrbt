create or replace function
    get_resultat(v_lot_id bigint, v_state integer,
                 v_organ_name character varying, v_maloy character varying,
                 v_from_summa bigint, v_to_summa bigint, v_proc_id integer,
                 v_date1 DATE,
                 v_date2 DATE) returns text
    language plpgsql
as
$$
Declare
r        record;
    dataJson jsonb := '[]';
BEGIN

for r in SELECT rm.id,
                rm.lot_id,
                ci.state,
                mpd.name   as "organ_name",
                rm.maloy,
                rm.p_summa as "summa",
                rm.proc_id,
                rm.contract_dat::DATE
         FROM resultat_method rm
                  INNER JOIN contract_info ci
                             ON rm.lot_id = ci.lot_id
                  LEFT JOIN man_organizations$payload$data mpd
                                  ON mpd.organ = rm.organ
         WHERE (rm.lot_id = v_lot_id OR v_lot_id = 9223372036854775807)
           AND (ci.state = v_state OR v_state = 2147483647)
           AND (v_organ_name = mpd.name OR v_organ_name = 'ALL')
           AND (v_maloy = rm.maloy OR v_maloy = 'ALL')
           AND (rm.p_summa between v_from_summa and v_to_summa)
           AND (v_proc_id = rm.proc_id OR v_proc_id = 2147483647)
           AND (rm.contract_dat BETWEEN v_date1 AND v_date2)
             loop
            dataJson = dataJson ||  jsonb_agg(r);
end loop;
return dataJson::text;
END;
$$;

alter function get_resultat(bigint, integer, varchar, varchar, bigint, bigint, integer, timestamp, timestamp) owner to postgres;

