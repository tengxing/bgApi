package cn.yjxxclub.bgApi.question.service.impl;

import cn.yjxxclub.bgApi.common.service.impl.BaseServiceImpl;
import cn.yjxxclub.bgApi.question.entity.Question;
import cn.yjxxclub.bgApi.question.mapper.QuestionMapper;
import cn.yjxxclub.bgApi.question.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-7-26
 * Time: 下午11:29
 * Describe:QuestionService实现类
 */
@Service("QuestionService")
@Transactional
public class QuestionServiceImpl extends BaseServiceImpl<QuestionMapper,Question> implements QuestionService{
}
