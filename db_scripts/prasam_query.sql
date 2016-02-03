Select 
	p.c_l_name_lat as Name,
	p.c_f_name_lat as Surname,
	tm.c_birth_date as 'Birth Date',
	p.c_citizenship as Citizenship,
	o.c_post as 'Position',
	concat(p.c_series, ' ', p.c_number) as 'Pass No',
	p.c_issue_date as 'Issue Date',
	p.c_expiry_date as 'Expery Date',
	concat_ws(', ', a.c_country, a.c_city, a.c_street, concat(a.c_building, concat('/', a.c_block), '-', a.c_flat), a.c_zip_code, tm.c_contact_phone) as Address

 from t_teammates as tm
 inner join t_passports as p
 on tm.c_fk_passport_id = p.c_ID
 inner join t_occupations as o
 on tm.c_fk_occupation_id = o.c_ID
 inner join t_addresses as a
 on tm.c_fk_current_address_id = a.c_ID;