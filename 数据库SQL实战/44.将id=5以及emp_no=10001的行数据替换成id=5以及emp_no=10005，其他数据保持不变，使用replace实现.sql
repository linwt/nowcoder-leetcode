update titles_test
set emp_no=10005
where id=5 and emp_no=10001;


replace into titles_test values
('5', '10005', 'Senior Engineer', '1986-06-26', '9999-01-01');


update titles_test
set emp_no=replace(emp_no, 10001, 10005);