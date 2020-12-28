import com.kk.dao.order_listMapper;
import com.kk.pojo.buy_book_time;
import com.kk.pojo.order_list;
import com.kk.utilis.mybatisutils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tt {
    @Test
    public void test() {
        SqlSession sqlSession= mybatisutils.getsqlsession();
        order_listMapper mapper=sqlSession.getMapper(order_listMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("userid","123");
        map.put("sigin","0");
        List<order_list> lists=mapper.selectuserorder(map);
        System.out.println(lists.size());
        String kk="";
        for (order_list list : lists) {
//            System.out.println(list);
            List<buy_book_time> b=list.getBuy_book_time();
            for (buy_book_time buy_book_time : b) {
                kk+=buy_book_time.getBook_name()+"-"+buy_book_time.getBook_nums()+"件-";
            }
        }
        System.out.println(kk.substring(0,kk.length()-1));
    }

}
