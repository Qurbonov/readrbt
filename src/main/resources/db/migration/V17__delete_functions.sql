drop function get_claim_info(v_lot_id bigint, v_organ_name varchar, v_from_summa bigint, v_to_summa bigint, v_srok integer, v_state integer, v_proc_id integer);
drop function get_resultat(v_lot_id bigint, v_state integer, v_organ_name varchar, v_maloy varchar, v_from_summa bigint, v_to_summa bigint, v_proc_id integer, v_date1 date, v_date2 date);
drop function get_resultat(v_lot_id bigint, v_state integer, v_organ_name varchar, v_maloy varchar, v_from_summa bigint, v_to_summa bigint, v_proc_id integer, v_date1 date, v_date2 date, v_limit integer, v_offset integer);
drop function get_request_etp(v_lot_id bigint, v_from_doc_date date, v_to_doc_date date, v_organ_name varchar, v_from_sum_lot bigint, v_to_sum_lot bigint, v_month integer, v_state integer, v_pltf integer);