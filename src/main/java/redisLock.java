import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;

public class redisLock {

    public static void main(String[] args) {
        Redisson redisson = null;

        RLock lock = redisson.getLock("myLock");

    }
}
