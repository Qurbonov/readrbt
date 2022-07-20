create or replace function get_chart_info_by_proc_id_and_etp_id(v_etp_id integer, v_proc_id integer, v_year integer) returns integer
    language plpgsql
as
$$
DECLARE
    r integer;
BEGIN
    select count("etp_id")
    into r
    from dxmap.public.resultat_method rm
             inner join dxmap.public.contract_info ci on ci.lot_id = rm.lot_id and ci.state = 2
    where extract(year from rm.contract_dat) = v_year
      and rm.proc_id = v_proc_id
      and rm.etp_id = v_etp_id;
    return r;
END
$$;

create function get_chart_info_by_proc_id(v_proc_id integer, v_year integer) returns text
    language plpgsql
as
$$
DECLARE
    r        record;
    dataJson jsonb := '[]';
BEGIN
    for x in 1..4
        loop
            select get_chart_info_by_proc_id_and_etp_id(x, v_proc_id, v_year) as "count", x as "etp_id" into r;
            dataJson = dataJson || jsonb_agg(r);
        end loop;
    return dataJson::text;
END
$$;

create function get_chart_info(v_year integer) returns text
    language plpgsql
as
$$
DECLARE
    dataJson jsonb := '{}';
BEGIN
    dataJson = dataJson || jsonb_build_object('transaction_completed_info', get_chart_info_by_proc_id(3, v_year)::jsonb);
    dataJson = dataJson || jsonb_build_object('digital_catalogue_info', get_chart_info_by_proc_id(6, v_year)::jsonb);
    dataJson = dataJson || jsonb_build_object('tender_info', get_chart_info_by_proc_id(17, v_year)::jsonb);
    dataJson = dataJson || jsonb_build_object('konkurs_info', get_chart_info_by_proc_id(18, v_year)::jsonb);
    dataJson = dataJson || jsonb_build_object('direct_contracts_info', get_chart_info_by_proc_id(19, v_year)::jsonb);
    return dataJson::text;
END
$$;