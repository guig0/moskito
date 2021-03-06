package net.anotheria.moskito.integration.cdi;

import javax.inject.Singleton;
import javax.interceptor.Interceptor;

/**
 * Data access layer call interceptor.
 * Intercepts DAO methods.
 *
 * @author <a href="mailto:vzhovtiuk@anotheria.net">Vitaliy Zhovtiuk</a>, <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Interceptor
@Singleton
@Monitor(MonitoringCategorySelector.DAO)
public class DaoCallInterceptor extends CallInterceptor {

    @Override
    public String getCategory() {
        return MonitoringCategorySelector.DAO;
    }
}
