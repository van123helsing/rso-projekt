package BeleziKlice;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import Zrna.BelezenjeKlicevZrno;

@Interceptor
@BeleziKlice
public class BelezenjeKlicevInterceptor {

    @Inject
    private BelezenjeKlicevZrno belezenjeKlicevZrno;

    @AroundInvoke
    public Object zabeleziKlic(InvocationContext context) throws Exception {

        belezenjeKlicevZrno.povecajSteviloKlicev();
        return context.proceed();
    }
}