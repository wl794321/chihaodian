package com.weixin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.weixin.controller.ButtonController;
import com.weixin.dao.ButtonMapper;
import com.weixin.entity.Button;
import com.weixin.pay.util.WeixinUtil;

import net.sf.json.JSONObject;

@Service
@Transactional
public class ButtonService {
	@Autowired
	private ButtonMapper buttonMapper;
	private static Logger log = LoggerFactory.getLogger(ButtonService.class);
	// 菜单创建（POST） 限1000（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    // 菜单查询（POST） 限10000（次/天）
    public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    // 菜单删除（POST） 限1000（次/天）
    public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	public int deleteByPrimaryKey(String id) {
		int rs = 0;
		try {
			rs = buttonMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			rs = -1;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return rs;
	}

	public int insert(Button record) {
		int rs = 0;
		try {
			rs = buttonMapper.insert(record);
		} catch (Exception e) {
			rs = -1;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return rs;
	}

	public Button selectByPrimaryKey(String id) {
		return buttonMapper.selectByPrimaryKey(id);
	}
	public int selectCount(Button record){
		return buttonMapper.selectCount(record);
	}
	public List<Button>  select(Button record) {
		return buttonMapper.select(record);
	}
	
	public int updateByPrimaryKey(Button record) {
		int rs = 0;
		try {
			rs = buttonMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			rs = -1;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return rs;
	}
	
	public int updateByPrimaryKeySelective(Button record) {
		int rs = 0;
		try {
			rs = buttonMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			rs = -1;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return rs;
	}
	public int sort(Button record) {
		int rs = 0;
		try {
			rs = buttonMapper.sort(record);
		} catch (Exception e) {
			rs = -1;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return rs;
	}

	public JSONObject getMenu(String at) {
		 // 拼装创建菜单的url
        String url = menu_get_url.replace("ACCESS_TOKEN", at);
        // 调用接口查询菜单
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "GET", null);

        return jsonObject;
	}

	public int createMenuSelf(String menu, String at) {
		int result = 0;

        // 拼装创建菜单的url
        String url = menu_create_url.replace("ACCESS_TOKEN", at);
       /* // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();*/
        // 调用接口创建菜单
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", menu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
                log.error("****"+menu+"****");
            }
        }
        return result;
	}
}
