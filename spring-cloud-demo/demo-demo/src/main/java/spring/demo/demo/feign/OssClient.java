package spring.demo.demo.feign;


import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author hyc
 * @version v1.0
 * @date 2017/6/28 15:50
 */
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface OssClient {




    @RequestLine(value = "POST /uploadImage?platformId={platformId}")
    Map<String, String> uploadImage(
            @Param("platformId") Long platformId,
            @RequestBody byte[] bytes) ;

//
//
//
//    /**
//     * 获取指定keypattern的keys
//     * @param platformId
//     * @param instanceId
//     * @param keyPattern
//     * @return
//     */
//    @RequestLine(value = "POST /v3/keys?platformId={platformId}&key={keyPattern}&instanceId={instanceId}")
//    @Body("{keyPattern}")
//    RespData<Set<String>> keys(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "keyPattern", value = "key的前缀,* 代表所有", required = false) @Param("keyPattern") String keyPattern) ;
//
//
//    /**
//     * 获取指定keypattern的keys
//     * @param platformId
//     * @param instanceId
//     * @param keyPattern
//     * @return
//     */
//    @RequestLine(value = "POST /v3/scan?platformId={platformId}&key={keyPattern}&instanceId={instanceId}&cursor={cursor}&length={length}")
//    @Body("{keyPattern}")
//    ScanResult<String> scan(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "keyPattern", value = "key的前缀,* 代表所有", required = false) @Param("keyPattern") String keyPattern,
//            @ApiParam(name = "cursor", value = "游标", required = true) @Param("cursor") int cursor,
//            @ApiParam(name = "length", value = "返回长度", required = true) @Param("length") Integer length) ;
//
//
//
//
//
//
//
//
//    /**
//     * 获取 key的数据类型
//     * @param platformId
//     * @param instanceId
//     * @param keys
//     * @return
//     */
//    @RequestLine(value = "POST /v3/type?platformId={platformId}&instanceId={instanceId}")
//    @Body("{keys}")
//    RespData<Map<String, String>> type(@ApiParam(name = "platformId", value = "平台id") @Param("platformId") Long platformId,
//                                       @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//                                       @ApiParam(name = "keys", value = "instanceId", required = false) @Param("keys") String keys
//    );
//
//    /**
//     * 获取租户实例
//     * @param platformId
//     * @return
//     */
//    @RequestLine(value = "POST /v3/get-map?pid={platformId}")
//    RespData<String> getMap(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId) ;
//
//
//
//    /**
//     *从cache读取字符串类型的数据
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @return
//     */
//    @RequestLine(value = "GET /v3/get?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<String> get(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key);
//
//
//    /**
//     * 获取key是set数据类型的素有元素
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @return
//     */
//    @RequestLine(value = "POST /v3/smember?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Set<String>> smember(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key);
//
//    /**
//     * 返回哈希表 key 中，所有的域和值
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @return
//     */
//    @RequestLine(value = "GET /v3/hgetall?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Map<String,String>> hgetAll(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key);
//
//
//
//
//    /**
//     * 返回列表 key 中指定区间内的元素
//     */
//    @RequestLine(value = "GET /v3/lrange?platformId={platformId}&key={key}&instanceId={instanceId}&start={start}&end={end}")
//    RespData<List<String>> lrange(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key,
//            @Param("start") Long start,
//            @Param("end") Long end);
//
//    /**
//     * 通过索引区间返回有序集合的成员
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @param start
//     * @param stop
//     * @param sort
//     * @return
//     */
//    @RequestLine(value = "GET /cache-service/v3/zrange?platformId={platformId}&key={key}&instanceId={instanceId}&start={start}&stop={stop}&sort={sort}")
//    RespData<List<String>> zrange(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key,
//            @Param("start") Long start,
//            @Param("stop") Long stop,
//            @Param("sort") Boolean sort);
//
//
//
//
//    @ApiOperation(value = "通过索引区间返回有序集合的带分数成员")
//    @RequestLine(value = "GET /v3/zrange-with-scores?platformId={platformId}&key={key}&instanceId={instanceId}&start={start}&stop={stop}&sort={sort}")
//    RespData<List<Map<String, Object>>> zrangeWithScores(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "SortedSet名称", required = true) @Param("key") String key,
//            @ApiParam(name = "start", value = "开始索引", required = true) @Param("start") Long start,
//            @ApiParam(name = "stop", value = "结束索引", required = true) @Param("stop") Long stop,
//            @ApiParam(name = "sort", value = "排序,默认从低到高,true从高到底") @Param(value = "sort") Boolean sort);
//
//
//    /**
//     * 存字符串类型的数据到cache
//     * @param platformId
//     * @param key
//     * @param instanceId
//     * @param value
//     * @return
//     */
//     @RequestLine(value = "POST /v3/set?platformId={platformId}&key={key}&instanceId={instanceId}")
//     @Body("{value}")
//     RespData<String> set(
//             @Param("platformId") Long platformId,
//             @Param("instanceId") String instanceId,
//             @Param("key") String key,
//             @Param("value") String value);
//
//
//    @RequestLine(value = "POST /v3/lpush?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Long> lpush(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key,
//            @ApiParam(name = "values", value = "cache value", required = true) @RequestBody String[] values) ;
//
//
//
//    @RequestLine(value = "GET /v3/lpop?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData lpop(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key) ;
//
//
//
//    @RequestLine(value = "POST /v3/sadd?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Long> sadd(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key,
//            @ApiParam(name = "values", value = "cache 元素", required = true) @RequestBody String[] values) ;
//
//
//
//
//    @RequestLine(value = "POST /v3/srem?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Long> srem(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param("instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key,
//            @ApiParam(name = "values", value = "cache values", required = true) @RequestBody String[] values) ;
//
//
//
//
//    @RequestLine(value = "POST /v3/hdel?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData hdel(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param("instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache的key", required = true) @Param("key") String key,
//            @ApiParam(name = "fields", value = "cache的value", required = true) @RequestBody String[] fields) ;
//
//
//
//    @RequestLine(value = "DELETE /v3/zrem?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData zrem(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param("instanceId") String instanceId,
//            @ApiParam(name = "key", value = "SortedSet名称", required = true) @Param("key") String key,
//            @ApiParam(name = "member", value = "成员", required = true) @RequestBody String[] member) ;
//
//
//
//    @ApiOperation(value = "向有序集合添加一个成员，或者更新已存在成员的分数")
//    @RequestLine(value = "POST /v3/zadd?platformId={platformId}&key={key}&instanceId={instanceId}&score={score}")
//    @Body("{member}")
//    RespData zadd(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = true) @Param("instanceId") String instanceId,
//            @ApiParam(name = "key", value = "SortedSet名称", required = true) @Param("key") String key,
//            @ApiParam(name = "score", value = "分数", required = true) @Param("score") Double score,
//            @ApiParam(name = "member", value = "成员", required = true) @Param("member") String member) ;
//
//
//    /**
//     * 哈希表 key 中的域 field 的值设为 value,多个field,value放在map中
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @param fvMap
//     * @return
//     */
//    @RequestLine(value = "POST /v3/hsetMap?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Long> hsetMap(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "cache key", required = true) @Param("key") String key,
//            @ApiParam(name = "fvMap", value = "cache 给定域值集合", required = true) @RequestBody Map<String, String> fvMap) ;
//
//
//    /**
//     * 向有序集合添加多个成员，或者更新已存在成员的分数
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @param memberMap
//     * @return
//     */
//    @RequestLine(value = "POST /v3/zadd-map?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData<Long> zaddForMap(
//            @ApiParam(name = "platformId", value = "平台id", required = true) @Param("platformId") Long platformId,
//            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//            @ApiParam(name = "key", value = "SortedSet名称", required = true) @Param("key") String key,
//            @ApiParam(name = "memberMap", value = "成员map,key为成员,value为分数", required = true) @RequestBody Map<String, Double> memberMap);
//
//
//    /**
//     * 哈希表 key 中的域 field 的值设为 value
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @param field
//     * @param value
//     * @return
//     */
//    @RequestLine(value = "POST /v3/hset?platformId={platformId}&key={key}&instanceId={instanceId}&field={field}")
//    @Body("{value}")
//    RespData hset(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key,
//            @Param("field") String field,
//            @Param("value") String value);
//
//    /**
//     * 从cache删除字符串类型的数据key
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @return
//     */
//    @RequestLine(value = "POST /v3/del?platformId={platformId}&key={key}&instanceId={instanceId}")
//    RespData del(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key);
//
//    /**
//     * 当key过期时(生存时间为 0 )，它会被自动删除
//     * @param platformId
//     * @param instanceId
//     * @param key
//     * @param seconds
//     * @return
//     */
//    @RequestLine(value = "POST /v3/expire?platformId={platformId}&key={key}&instanceId={instanceId}&seconds={seconds}")
//    RespData expire(
//            @Param("platformId") Long platformId,
//            @Param("instanceId") String instanceId,
//            @Param("key") String key,
//            @Param("seconds") Integer seconds);
//
//
//
//
//    @RequestLine(value = "POST /v3/rename?platformId={platformId}&instanceId={instanceId}&oldkey={oldkey}&newkey={newkey}")
//    RespData<String> rename(@ApiParam(name = "platformId", value = "平台id") @Param("platformId") Long platformId,
//                            @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//                            @ApiParam(name = "oldkey", value = "oldkey", required = false) @Param(value = "oldkey") String oldkey,
//                            @ApiParam(name = "newkey", value = "newkey", required = false) @Param(value = "newkey") String newkey
//    );
//
//
//
//
//    @RequestMapping(value = "/exists", method = RequestMethod.GET)
//    @RequestLine(value = "GET /v3/exists?platformId={platformId}&instanceId={instanceId}&key={key}")
//    RespData<Boolean> exists(@ApiParam(name = "platformId", value = "平台id") @Param("platformId") Long platformId,
//                             @ApiParam(name = "instanceId", value = "instanceId", required = false) @Param(value = "instanceId") String instanceId,
//                             @ApiParam(name = "key", value = "key", required = false) @Param(value = "key") String key
//    );


}
