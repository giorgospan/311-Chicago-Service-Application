create or replace function top_five_ssa (t1 timestamp, t2 timestamp )
    returns table ( ssa integer, creationdate date, ranking bigint)
as
$func$
BEGIN

    return query

        with cte as
                 (
                     select t.request_id, t.ssa, t.creation_date from(
                                     (
                                         select vehicle_request.ssa,request.request_id,request.creation_date
                                         from request,vehicle_request
                                         where vehicle_request.ssa is not null
                                           and request.creation_date between t1 and t2
                                           and request.request_id = vehicle_request.request_id
                                     )
                                     union all
                                     (
                                         select garbage_request.ssa,request.request_id,request.creation_date
                                         from request,garbage_request
                                         where garbage_request.ssa is not null
                                           and request.creation_date between t1 and t2
                                           and request.request_id = garbage_request.request_id
                                     )
                                     union all
                                     (
                                         select pothole_request.ssa,request.request_id,request.creation_date
                                         from request,pothole_request
                                         where pothole_request.ssa is not null
                                           and request.creation_date between t1 and t2
                                           and request.request_id = pothole_request.request_id
                                     )
                                     union all
                                     (
                                         select graffiti_request.ssa,request.request_id,request.creation_date
                                         from request,graffiti_request
                                         where graffiti_request.ssa is not null
                                           and request.creation_date between t1 and t2
                                           and request.request_id = graffiti_request.request_id
                                     )
                                 )as t
                 )

        select * from(

                         select cte.ssa, date(cte.creation_date),
                                rank() OVER (PARTITION BY date(cte.creation_date)  ORDER BY count(cte.request_id) DESC) as ranking
                         from cte
                         group by cte.ssa, date(cte.creation_date)
                     )as t
        where t.ranking<=5;

END
$func$  LANGUAGE plpgsql;

CREATE EXTENSION IF NOT EXISTS postgis
    SCHEMA public
--- commenting the following line because it may result to errors
---    VERSION '3.0.2';

