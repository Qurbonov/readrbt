CREATE OR REPLACE FUNCTION
get_resultat(v_lot_id VARCHAR, v_state VARCHAR,
     v_organ_name VARCHAR, v_maloy VARCHAR,
     v_from_summa BIGINT, v_to_summa BIGINT,
   v_proc_id BIGINT, v_date1 DATE, v_date2 DATE)
    RETURNS TABLE (
    id BIGINT,
    lot_id VARCHAR,
    "state" VARCHAR,
    organ_name VARCHAR,
    maloy VARCHAR,
    summa BIGINT,
    proc_id BIGINT,
  lot_date1 DATE,
  lot_date2 DATE)
AS $$
BEGIN
RETURN QUERY
SELECT rm.id, rm.lot_id,
       ci.state, mpd.name as "organ_name",
       rm.maloy, rm.p_summa as "summa",
       rm.proc_id, rm.lot_date1, rm.lot_date2
         FROM resultat_method rm
         INNER JOIN contract_info ci
         ON rm.lot_id = ci.lot_id
         INNER JOIN man_organizations$payload$data mpd
                    ON mpd.organ = rm.organ
WHERE (rm.lot_id = v_lot_id OR v_lot_id = 'ALL')
  AND (ci.state = v_state OR v_state = 'ALL')
  AND (v_organ_name = mpd.name OR v_organ_name = 'ALL')
  AND (v_maloy = rm.maloy OR v_maloy = 'ALL')
  AND (v_from_summa <= rm.p_summa AND rm.p_summa <= v_to_summa)
  AND (v_proc_id = rm.proc_id OR v_proc_id = 9223372036854775807)
  AND (v_date1 = rm.lot_date1 OR v_date1 = (CURRENT_DATE + INTERVAL '1 day'))
  AND (v_date2 = rm.lot_date2 OR v_date2 = (CURRENT_DATE + INTERVAL '1 day'));
END;
$$
LANGUAGE 'plpgsql';