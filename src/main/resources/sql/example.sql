select table_name from user_tables;

select e.EMPNO    as emp_empno,
	   e.ENAME    as emp_ename,
	   e.JOB	  as emp_job,
	   e.MGR	  as emp_mgr,
	   e.HIREDATE as emp_hiredate,
	   e.SAL	  as emp_sal,
	   e.COMM	  as emp_comm,
	   e.DEPTNO	  as emp_deptno,
	   d.DEPTNO   as dept_deptno,
	   d.DNAME    as dept_dname,
	   d.LOC	  as dept_loc	   
  from emp e left outer join dept d
    on e.deptno = d.deptno;
	
select c1.ID				as city_id,
	   c1.NAME				as city_name,
	   c1.COUNTRY_CODE		as city_country_code,
	   c1.DISTRICT			as city_district,
	   c1.POPULATION		as city_population,	   
	   c2.CODE 				as country_code,
	   c2.NAME 				as country_name,
	   c2.CONTINENT 		as country_continent,
	   c2.REGION 			as country_region,
	   c2.SURFACE_AREA  	as country_surface_area,
	   c2.INDEP_YEAR		as country_indep_year,
	   c2.POPULATION 		as country_population,
	   c2.LIFE_EXPECTANCY	as country_life_expectancy,
	   c2.GNP 				as country_gnp,
	   c2.GNP_OLD 			as country_gnp_old,
	   c2.LOCALNAME 		as country_local_name,
	   c2.GOVERNMENT_FORM	as country_government_form,
	   c2.HEAD_OF_STATE		as country_head_of_state,
	   c2.CAPITAL	 		as country_capital,
	   c2.CODE2				as country_code2	   
  from city c1 left outer join country c2
    on c1.country_code = c2.code
 WHERE c1.country_code = 'KOR';
 
 
 --City Paging
 --
 select count(*) from city;
 
 
 select *
   from city
  order by id
 offset 40 rows
  fetch next 10 rows only;
  
  
  
  select count(*)
    from city
   where country_code = 'KOR';
 
 --
 -- selectPage
 --
 select *
   from city
--   where country_code = 'KOR'
   ORDER BY id
 offset 2 ROWS
  FETCH NEXT 3 ROWS only;
 
 --
 -- selectPageWithCountry
 --
 select *
   from city c1 left outer join country c2
     on c1.COUNTRY_CODE = c2.CODE
--   WHERE c1.COUNTRY_CODE = 'KOR'
  ORDER BY ID
 offset 2 rows
  fetch next 3 rows only;
  

--
-- CountryMapper.selectPage
--  
  
select *
  from country
 order by code
offset 2 rows
 fetch next 3 rows only;
 
select *
  from city
 where country_code = 'AGO';

select *
  from city
 where country_code = 'AIA';
  
--
-- CountryMapper.selectPageWithCity
-- 

select *
  from country c1 left outer join city c2
    on c1.code = c2.country_code
 order by c1.code
offset 2 rows
 fetch next 3 rows only;


