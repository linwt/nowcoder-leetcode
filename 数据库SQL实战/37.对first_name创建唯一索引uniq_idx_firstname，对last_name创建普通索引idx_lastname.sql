-- 创建唯一索引
create unique index uniq_idx_firstname on actor(first_name);
-- 创建普通索引
create index idx_lastname on actor(last_name);