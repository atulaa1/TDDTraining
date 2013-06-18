package com.dis;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/14/13
 * Time: 11:25 AM
 */
public class TestTimeOut {

        @org.junit.Test
        public void testTimeout() throws Exception {
            final List mock = mock(List.class, Mockito.CALLS_REAL_METHODS);
            A mockA = mock(A.class,Mockito.CALLS_REAL_METHODS);
           /* new Thread(){
                @Override
                public void run() {
                    try {
                        mock.get(2);
                        Thread.sleep(1000);
                        mock.get(1);
                    } catch (InterruptedException e) {
                    }
                }
            }.start();*/
//            mock.get(2);
//            verify(mock, timeout(3000)).get(2);

            mockA.callme();
            mockA.test1();

            verify(mockA, timeout(4000).times(2)).callme();

//            verify(mock, timeout(30000)).get(1);
        }

}
