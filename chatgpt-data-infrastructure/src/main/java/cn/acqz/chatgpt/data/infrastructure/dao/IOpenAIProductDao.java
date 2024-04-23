package cn.acqz.chatgpt.data.infrastructure.dao;

import cn.acqz.chatgpt.data.infrastructure.po.OpenAIProductPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qz
 * @description 商品Dao
 * @date 2023-10-05 13:27
 */
@Mapper
public interface IOpenAIProductDao {

    OpenAIProductPO queryProductByProductId(Integer productId);

    List<OpenAIProductPO> queryProductList();

}
