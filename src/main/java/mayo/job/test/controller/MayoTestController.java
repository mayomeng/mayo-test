package mayo.job.test.controller;

import mayo.job.client.JobClient;
import mayo.job.client.impl.JobClientFactory;
import mayo.job.parent.param.JobParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SKJ-05A14-0049 on 2018/3/6.
 */
@RestController
public class MayoTestController {

    @Autowired
    private JobClientFactory jobClientFactory;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping(value = "/mayo/sync", method = RequestMethod.POST)
    public Object sync() throws Exception {
        JobClient jobClient = jobClientFactory.getJobClient();
        Map<String, Object> params = new HashMap();
        params.put("id", 1);
        params.put("name", "syncTest");
        JobParam jobParam = new JobParam();
        jobParam.setJobName("Test");
        jobParam.setParams(params);
        jobParam.setSubmitTime(new Date());
        JobParam jobResult = jobClient.syncRequest(jobParam);
        return jobResult;
    }

    @RequestMapping(value = "/mayo/async", method = RequestMethod.POST)
    public Object async(Integer id, String name) {
        JobClient jobClient = jobClientFactory.getJobClient();
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        params.put("name", name);
        JobParam jobParam = new JobParam();
        jobParam.setJobName("Test");
        jobParam.setParams(params);
        jobParam.setSubmitTime(new Date());
        long jobId = jobClient.asynRequest(jobParam);
        return jobId;
/*        JobParam jobResult = jobClient.queryResult(jobId);
        return jobResult;*/
    }
}
