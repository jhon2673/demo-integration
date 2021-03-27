--
-- Created by IntelliJ IDEA.
-- User: pzh
-- Date: 2020/7/23
-- Time: 20:52
-- 抢红包的lua脚本
--

-- KEYS[1] = 红包队列Key
-- KEYS[2] = 抢到红包的用户Hash Key
-- ARGV[1] = 用户ID
-- 如果用户已经抢到过红包，则返回0
if redis.call('hexists', KEYS[2], ARGV[1]) ~= 0 then
    return 0
end
-- 如果用户没抢到过,先查看红包数量是否足够
if redis.call('llen', KEYS[1]) ~= 0 then
    -- 	如果仍剩余红包，则取出一个红包
    local money = redis.call('rpop', KEYS[1])
    -- 	将用户信息和红包金额保存
    redis.call('hset', KEYS[2], ARGV[1], money)
    return 1
end
-- 如果无红包了，则返回2表示红包已经抢完
return 2

