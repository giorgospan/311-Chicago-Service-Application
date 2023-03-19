select zip_code, count(zip_code)
from request
group by zip_code
order by 2 DESC


-------------------------------------------------------------------------------------------------------------------------------------------------
-- select request_type, count(*) as total_requests
-- from request
-- where creation_date between '2000-01-12' and '2019-01-12'
-- group by request_type
-- order by total_requests DESC
-------------------------------------------------------------------------------------------------------------------------------------------------
-- select count(*) as total_requests,date(creation_date) 
-- from request
-- where request_type = 'Abandoned Vehicle Complaint' and creation_date between '2010-01-12' and '2019-01-12'
-- group by 2
-- order by 2 DESC
-------------------------------------------------------------------------------------------------------------------------------------------------

-- with cte_requests as(
-- 	SELECT zip_code,request_type ,
-- 	ROW_NUMBER() OVER (PARTITION BY zip_code ORDER BY count(request_type) DESC) as row_num
-- 	FROM request
-- 	WHERE creation_date = '2019-11-26'
-- 	GROUP BY zip_code, request_type
-- )
-- select zip_code, request_type
-- from cte_requests 
-- where row_num = 1

-------------------------------------------------------------------------------------------------------------------------------------------------

-- select request_type, round(avg(EXTRACT(EPOCH FROM (completion_date-creation_date)))) as avg_compl_time
-- from request
-- where creation_date between '2000-01-12 00:12:00.0' and '2019-01-12 00:12:00.0'
-- group by request_type

-------------------------------------------------------------------------------------------------------------------------------------------------

-- select request_type as requestType, count(request_type) as typeCount
-- from request 
-- where ST_MakePoint(longitude,latitude) && ST_MakeEnvelope(-87.67273,41.846234,-87.628981,41.893898, 4326) 
-- and creation_date = '2016-01-22'
-- group by request_type
-- order by typeCount desc
-- limit 1;

-------------------------------------------------------------------------------------------------------------------------------------------------
-- with cte_ssa as
-- (
-- 	select request_id, ssa, creation_date from(
-- 		(
-- 			select ssa,request.request_id,request.creation_date
-- 			from request,vehicle_request
-- 			where ssa is not null
-- 			and request.creation_date between '2000-01-12' 
-- 			and '2019-01-12' 
-- 			and request.request_id = vehicle_request.request_id
-- 		)
-- 		union all
-- 		(
-- 			select ssa,request.request_id,request.creation_date
-- 			from request,garbage_request
-- 			where ssa is not null
-- 			and request.creation_date between '2000-01-12' 
-- 			and '2019-01-12' 
-- 			and request.request_id = garbage_request.request_id
-- 		)
-- 		union all
-- 		(
-- 			select ssa,request.request_id,request.creation_date
-- 			from request,pothole_request
-- 			where ssa is not null
-- 			and request.creation_date between '2000-01-12' 
-- 			and '2019-01-12' 
-- 			and request.request_id = pothole_request.request_id
-- 		)
-- 		union all
-- 		(
-- 			select ssa,request.request_id,request.creation_date
-- 			from request,graffiti_request
-- 			where ssa is not null
-- 			and request.creation_date between '2000-01-12' 
-- 			and '2019-01-12' 
-- 			and request.request_id = graffiti_request.request_id
-- 		)
-- 	)as t
-- )

-- select * from(

-- 	select ssa, date(creation_date),
-- 	rank() OVER (PARTITION BY creation_date  ORDER BY count(request_id) DESC) as ranking
-- 	from cte_ssa
-- 	group by ssa, creation_date
-- )as t
-- where ranking<=5
-------------------------------------------------------------------------------------------------------------------------------------------------

-- select licence_plate, count(*) as counts
-- from vehicle_request
-- WHERE licence_plate is not null
-- GROUP BY licence_plate
-- HAVING count(*)  > 1
-- order by count(*) DESC

-------------------------------------------------------------------------------------------------------------------------------------------------
-- SELECT vehicle_color, COUNT(vehicle_color) AS occurences 
-- FROM vehicle_request
-- GROUP BY vehicle_color
-- ORDER BY occurences DESC
-- LIMIT 1 OFFSET 1;
-------------------------------------------------------------------------------------------------------------------------------------------------

-- select request_id, premises_baited
-- from rodent_request
-- where premises_baited < 240
-- order by 2 DESC
-------------------------------------------------------------------------------------------------------------------------------------------------

-- select request_id, premises_with_garbage 
-- from rodent_request
-- where premises_with_garbage < 100
-- order by 2 DESC

-------------------------------------------------------------------------------------------------------------------------------------------------

-- select request_id, premises_with_rats
-- from rodent_request
-- where premises_with_rats < 67
-- order by 2 desc

-------------------------------------------------------------------------------------------------------------------------------------------------
-- select police_district 
-- from
-- (
-- 	select request.police_district
-- 	from request inner join pothole_request on request.request_id = pothole_request.request_id
-- 	where potholes_filled > 1 and creation_date = '2018-01-13' 
-- )as t
-- where t.police_district in 
-- (
-- 	select request.police_district
-- 	from request inner join rodent_request on request.request_id = rodent_request.request_id
-- 	where premises_baited > 1 and creation_date = '2018-01-13' 

-- )


-- select distinct t.police_district as lol
-- from
-- (
-- 	select request.police_district
-- 	from request inner join pothole_request on request.request_id = pothole_request.request_id
-- 	where potholes_filled > 1 and creation_date = '2018-01-13' 
-- )as t, rodent_request, request
-- where premises_baited > 1 
-- and creation_date = '2018-01-13'
-- and request.police_district = t.police_district
-- and request.request_id = rodent_request.request_id





