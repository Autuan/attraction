package com.attraction.modular.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.attraction.common.exception.CheckException;
import com.attraction.common.util.LoginUtil;
import com.attraction.modular.member.entity.Member;
import com.attraction.modular.member.entity.MemberExample;
import com.attraction.modular.member.mapper.MemberMapper;
import com.attraction.modular.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 新增
     * @param member
     */
    @Override
    public int insertMember(Member member) {
        if(checkUser(member.getAccount()) > 0 ) {
            throw new CheckException("此用户名已存在");
        }
        if(StrUtil.isBlank(member.getName())) {
            member.setName(member.getAccount());
        }
        return memberMapper.insertSelective(member);
    }

    /**
     * 更新
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        if(StrUtil.isBlank(member.getPassword())) {
            member.setPassword(null);
        } else {
            member.setPassword(LoginUtil.getSHA256Str(member.getPassword()));
        }
        if(StrUtil.isBlank(member.getName())) {
            member.setName(null);
        }
        memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     * 删除
     * @param memberId
     */
    @Override
    public void deleteMember(Integer memberId) {
        memberMapper.deleteByPrimaryKey(memberId);
    }

    @Override
    public Member userLogin(String username, String password) {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andAccountEqualTo(username)
                .andPasswordEqualTo(password);
        List<Member> members = memberMapper.selectByExample(example);
        return CollUtil.isEmpty(members) ? null : members.get(0);
    }

    @Override
    public int checkUser(String username, String password) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(password)) {
            criteria.andPasswordEqualTo(password);
        }
        criteria.andAccountEqualTo(username);
        return memberMapper.countByExample(example);
    }

    @Override
    public int checkUser(String username) {
        return checkUser(username,null);
    }
}
