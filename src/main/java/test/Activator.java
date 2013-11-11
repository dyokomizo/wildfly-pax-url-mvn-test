package test;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private Bundle bundle;

	public void start(BundleContext context) throws Exception {
		System.out.println("Activator: Installed Bundles List");
		for (final Bundle bundle : context.getBundles()) {
			System.out.println(bundle.getSymbolicName() + " " + stateAsString(bundle.getState()));
		}
		System.out.println("Activator: Installing Guava");
		bundle = context.installBundle("mvn:com.google.guava/guava/12.0");
		System.out.println("Activator: Installed Guava");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Activator: Uninstalling " + (bundle == null ? "<null>" : bundle.getSymbolicName()));
		if (bundle == null) { return; }
		bundle.uninstall();
		System.out.println("Activator: Uninstalled Guava");
	}

	private String stateAsString(int state) {
		switch (state) {
		case Bundle.UNINSTALLED:
			return "UNINSTALLED";
		case Bundle.INSTALLED:
			return "INSTALLED";
		case Bundle.RESOLVED:
			return "RESOLVED";
		case Bundle.STARTING:
			return "STARTING";
		case Bundle.STOPPING:
			return "STOPPING";
		case Bundle.ACTIVE:
			return "ACTIVE";
		default:
			return "BundleState(" + state + ")";
		}
	}
}
