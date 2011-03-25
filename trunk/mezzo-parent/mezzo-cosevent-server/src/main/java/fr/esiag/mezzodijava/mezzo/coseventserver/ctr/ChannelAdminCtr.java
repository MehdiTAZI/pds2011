package fr.esiag.mezzodijava.mezzo.coseventserver.ctr;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushConsumer;
import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushConsumerHelper;
import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushConsumerPOATie;
import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushSupplier;
import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushSupplierHelper;
import fr.esiag.mezzodijava.mezzo.cosevent.ProxyForPushSupplierPOATie;
import fr.esiag.mezzodijava.mezzo.coseventserver.factory.BFFactory;
import fr.esiag.mezzodijava.mezzo.coseventserver.impl.ProxyForPushConsumerImpl;
import fr.esiag.mezzodijava.mezzo.coseventserver.impl.ProxyForPushSupplierImpl;

/**
 * Classe ChannelAdminCtr
 * 
 * For Proxy creation : create, store in POA and return the Proxy
 * 
 * UC n°: US14,US15 (+US children)
 * 
 * @author Mezzo-Team
 * 
 */

public class ChannelAdminCtr {
    private Map<ProxyForPushConsumer, byte[]> oidProxyForPushConsumerMap = Collections
	    .synchronizedMap(new HashMap<ProxyForPushConsumer, byte[]>());
    private Map<ProxyForPushSupplier, byte[]> oidProxyForPushSupplierMap = Collections
	    .synchronizedMap(new HashMap<ProxyForPushSupplier, byte[]>());
    private String channel;
    private ChannelCtr channelCtr;
    private ORB orb;
    private static POA poa;

    /**
     * Build a Channel Admin Controler associated with a channelCtr.
     * 
     * @param topic
     *            Channel topic.
     */
    public Map<ProxyForPushConsumer, byte[]> getOidProxyForPushConsumerMap() {
	return oidProxyForPushConsumerMap;
    }

    public Map<ProxyForPushSupplier, byte[]> getOidProxyForPushSupplierMap() {
	return oidProxyForPushSupplierMap;
    }

    public ChannelAdminCtr(String topic) {
	this.channel = topic;
	this.orb = BFFactory.createOrb(null, null);
	this.channelCtr = BFFactory.createChannelCtr(topic);
    }

    private static synchronized POA getPOA() {
	try {
	    if (poa == null) {
		poa = POAHelper.narrow(BFFactory.getOrb()
			.resolve_initial_references("RootPOA"));
		poa.the_POAManager().activate();
	    }

	} catch (InvalidName e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (AdapterInactive e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return poa;
    }

    /**
     * Create the Proxy For PUSH Consumer and serve it with te CORBA POA.
     * 
     * @return A Corba Object.
     * @throws WrongPolicy
     * @throws ServantNotActive
     */
    public ProxyForPushConsumer createProxyForPushConsumer(String idComponent) {
	ProxyForPushConsumer pps = null;

	byte[] oid;
	try {
	    oid = getPOA()
		    .servant_to_id(
			    new ProxyForPushConsumerPOATie(
				    new ProxyForPushConsumerImpl(channel,
					    idComponent)));
	    pps = ProxyForPushConsumerHelper.narrow(getPOA().id_to_reference(
		    oid));
	    oidProxyForPushConsumerMap.put(pps, oid);
	} catch (ServantNotActive e) {
	    e.printStackTrace();
	} catch (WrongPolicy e) {
	    e.printStackTrace();
	} catch (ObjectNotActive e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return pps;

    }

    /**
     * Create the Proxy For PUSH Supplier and serve it with te CORBA POA.
     * 
     * @return A Corba Object.
     * @throws WrongPolicy
     * @throws ServantNotActive
     */
    public ProxyForPushSupplier createProxyForPushSupplier(String idComponent) {
	ProxyForPushSupplier ppc = null;
	
	byte[] oid;
	try {
	    oid = getPOA()
		    .servant_to_id(
			    new ProxyForPushSupplierPOATie(
				    new ProxyForPushSupplierImpl(channel,
					    idComponent)));
	    ppc = ProxyForPushSupplierHelper.narrow(getPOA().id_to_reference(
		    oid));
	    oidProxyForPushSupplierMap.put(ppc, oid);
	} catch (ServantNotActive e) {
	    e.printStackTrace();
	} catch (WrongPolicy e) {
	    e.printStackTrace();
	} catch (ObjectNotActive e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return ppc;
    }

    /**
     * Get the Channel topic.
     * 
     * @return topic
     */
    public String getTopic() {
	return channel;
    }

}
