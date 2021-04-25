package factorypack;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ExportImpl extends DelegatingIntroductionInterceptor implements Export {

	@Override
	public void doExport() {
		System.out.println("Do export method called....");
		
	}

}
