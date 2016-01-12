Select 
	p.l_name_lat as Name, 
	p.f_name_lat as Surname,
	tm.birth_date as 'Birth Date',
	p.citizenship as Citizenship, 
	o.post as 'Position',
	concat(p.series, ' ', p.number) as 'Pass No',
	p.issue_date as 'Issue Date',
	p.expiry_date as 'Expery Date', 
	concat_ws(', ', a.country, a.city, a.street, concat(a.building, concat('/', a.block), '-', a.flat), a.zip_code, tm.contact_phone) as Address

 from teammates as tm
 inner join passports as p
 on tm.fk_passport_id = p.ID
 inner join occupations as o
 on tm.fk_occupation_id = o.ID
 inner join addresses as a
 on tm.fk_current_address_id = a.ID; 