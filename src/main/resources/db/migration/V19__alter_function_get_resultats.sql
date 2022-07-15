create or replace function get_resultat(v_etp_id integer, v_lot_id bigint, v_organ_name character varying, v_organ_inn character varying, v_maloy character varying, v_vendor_inn character varying, v_vendor_name character varying, v_contract_num character varying, v_proc_id integer, v_date1 date, v_date2 date, v_limit integer, v_offset integer) returns text
    language plpgsql
as
$$
Declare
    r        record;
    r2       record;
    dataJson jsonb := '[]';
BEGIN
    for r in SELECT rm.id,
                    rm.lot_id,
                    rm.contract_beg,
                    rm.contract_end,
                    rm.avans_day,
                    rm.etp_id,
                    rm.purpose,
                    rm.vendor_acc,
                    rm.vendor_bank,
                    2          as "state",
                    mpd.name   as "organ_name",
                    rm.maloy,
                    rm.p_summa as "summa",
                    rm.proc_id,
                    rm.contract_dat::DATE,
                    rm.vendor_country,
                    rm.vendor_inn,
                    rm.vendor_name,
                    rm.p_avans,
                    rm.beneficiar,
                    rm.avans_day,
                    rm.contract_num
             FROM resultat_method rm
                      LEFT JOIN man_organizations$payload$data mpd
                                ON mpd.organ = rm.organ
             WHERE (rm.lot_id = v_lot_id OR v_lot_id = 9223372036854775807)
               AND (v_organ_name = mpd.name OR v_organ_name = 'ALL')
               AND (v_organ_inn = rm.inn OR v_organ_name = 'ALL')
               AND (v_maloy = rm.maloy OR v_maloy = 'ALL')
               AND (v_vendor_inn = rm.vendor_inn OR v_vendor_inn = 'ALL')
               AND (v_vendor_name = rm.vendor_name OR v_vendor_name = 'ALL')
               AND (v_contract_num = rm.contract_num OR v_contract_num = 'ALL')
               AND (v_proc_id = rm.proc_id OR v_proc_id = 2147483647)
               AND (v_etp_id = rm.etp_id OR v_etp_id = 2147483647)
               AND (rm.contract_dat BETWEEN v_date1 AND v_date2)
             limit v_limit offset (v_offset - 1) * v_limit
        loop
            select *
            into r2
            from contract_info ci
            where ci.lot_id = r.lot_id
              and ci.state = 2
            ORDER BY ci.version DESC
            LIMIT 1;
            if FOUND then
                dataJson = dataJson || jsonb_agg(r);
            end if;
        end loop;

    return dataJson::text;
END;
$$;

alter function get_resultat(integer, bigint, varchar, varchar, varchar, varchar, varchar, varchar, integer, date, date, integer, integer) owner to postgres;

