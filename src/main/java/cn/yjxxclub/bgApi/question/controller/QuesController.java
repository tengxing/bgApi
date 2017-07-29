package cn.yjxxclub.bgApi.question.controller;

import cn.yjxxclub.bgApi.common.util.PageBean;
import cn.yjxxclub.bgApi.common.util.ResponseUtil;
import cn.yjxxclub.bgApi.question.entity.Question;
import cn.yjxxclub.bgApi.question.service.QuestionService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-25
 * Time: 下午1:03
 * Describe: 问题页面控制器
 */
@RestController
@RequestMapping("/ques")
public class QuesController {
    private static final Logger logger = LoggerFactory.getLogger(QuesController.class);

    @Resource
    QuestionService questionService;

    /**
     * 问题添加
     * @param ques
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/add")
    public Object addQues(Question ques, HttpServletRequest request,
                          HttpServletResponse response)throws Exception{
        ques.setQuesId(UUID.randomUUID().toString());
        int q = questionService.add(ques);
        JSONObject result = new JSONObject();
        logger.info(ques.getDescription());
        if (q>0){
            result.put("success",true);
            result.put("status",200);
        }else {
            result.put("success",false);
            result.put("status",500);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 更新
     * @param ques
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/update")
    public Object updateQues(Question ques,HttpServletResponse response) throws Exception{
        JSONObject result = new JSONObject();
        if( null==ques.getId()||ques.getId().equals("")){
            if (ques.getIsSolved()=="Y"){
                Timestamp t = new Timestamp(new Date().getTime());
                ques.setSolvedTime(t);
            }
            result.put("success",false);
            result.put("status",500);
            result.put("code","没有id");
            logger.info("error：没有quesid");
            ResponseUtil.write(response,result);
            return null;
        }
        int q =questionService.update(ques);
        if (q>0){
            result.put("success",true);
            result.put("status",200);
        }else {
            result.put("success",false);
            result.put("status",500);
        }
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 所有数据
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/listTotal")
    public Object listTotal(HttpServletResponse response)throws Exception{
        List<Question> list = questionService.listTotal();
        JSONObject result = new JSONObject();
        result.put("totalQues",list);
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 分页获取数据
     * @param page
     * @param size
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/listByPage")
    public Object listByPage(String page,String size,
                             HttpServletRequest request, HttpServletResponse response)throws Exception{

        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(size));

        Map<String,Object> map = new HashMap();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        List<Question> list = questionService.listByPage(map);
        long total = questionService.countTotal();
        //JSONArray json = JSONArray.(list);
        JSONObject result = new JSONObject();
        result.put("rows",list);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    @GetMapping("/deleteById")
    public Object deleteById(Integer id,String quesId,
                             HttpServletRequest request, HttpServletResponse response) throws Exception{
        int q=0;
        // q= questionService.deleteById(id);
        Map<String,Object> map = new HashMap();
        map.put("id",id);
        map.put("quesId",quesId);
        map.put("status",0);//设置为不可取
        q = questionService.updateByMap(map);
        JSONObject result = new JSONObject();
        if (q>0){
            result.put("success",true);
            result.put("status",200);
        }else {
            result.put("success",false);
            result.put("status",500);
        }
        ResponseUtil.write(response,result);
        return null;
    }
}
