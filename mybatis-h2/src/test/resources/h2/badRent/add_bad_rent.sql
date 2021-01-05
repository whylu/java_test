
INSERT INTO bad_rent(address, rent_price, message, longitude, latitude, submit_time)
values ('badRent.address', 932131.12345, 'badRent.message', 0.1234567, 0.2345678, (extract(epoch from now() at time zone 'UTC')*1000)::bigint);

INSERT INTO bad_rent(address, rent_price, message, longitude, latitude, submit_time)
values ('badRent.address2', 2000, 'badRent.message22222', 0.1234567, 0.2345678, (extract(epoch from now() at time zone 'UTC')*1000)::bigint);
