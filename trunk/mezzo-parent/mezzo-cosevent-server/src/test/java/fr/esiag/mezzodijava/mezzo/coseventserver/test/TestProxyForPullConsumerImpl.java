package fr.esiag.mezzodijava.mezzo.coseventserver.test;


import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.esiag.mezzodijava.mezzo.cosevent.AlreadyConnectedException;
import fr.esiag.mezzodijava.mezzo.cosevent.ChannelNotFoundException;
import fr.esiag.mezzodijava.mezzo.cosevent.MaximalConnectionReachedException;
import fr.esiag.mezzodijava.mezzo.cosevent.NotConnectedException;
import fr.esiag.mezzodijava.mezzo.coseventserver.ctr.ChannelCtr;
import fr.esiag.mezzodijava.mezzo.coseventserver.factory.BFFactory;
import fr.esiag.mezzodijava.mezzo.coseventserver.impl.ProxyForPullConsumerImpl;
import fr.esiag.mezzodijava.mezzo.coseventserver.model.Channel;

public class TestProxyForPullConsumerImpl {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConnect() throws ChannelNotFoundException,
	MaximalConnectionReachedException, AlreadyConnectedException {
		
		// création du mock pour le contrôleur
		ChannelCtr mockCtr = EasyMock.createMock(ChannelCtr.class);
		// inject mock in Factory
		BFFactory.setAlternateChannelCtr("TEST_CONNECT", mockCtr);
		// nouveau proxy
		ProxyForPullConsumerImpl pfpc = new ProxyForPullConsumerImpl("TEST_CONNECT","testconsumer");
		mockCtr.addProxyForPullConsumerToConnectedList(pfpc);
		//pour que l'appel getChannel.getTopic() fonctionne
		EasyMock.expect(mockCtr.getChannel()).andReturn(new Channel("TEST_CONNECT", 1));
		// enregistrement
		EasyMock.replay(mockCtr);
		
		// lancement du test de la méthode
		pfpc.connect();
		
		// vérification de l'appel à la méthode d'ajout
		EasyMock.verify(mockCtr);
		pfpc = null;
	}

	@Test
	public void testDisconnect() throws ChannelNotFoundException,
	NotConnectedException {
		
		// création du mock pour le contrôleur
		ChannelCtr mockCtr = EasyMock.createMock(ChannelCtr.class);
		// inject mock in Factory
		BFFactory.setAlternateChannelCtr("TEST", mockCtr);
		// nouveau proxy
		ProxyForPullConsumerImpl pfpc = new ProxyForPullConsumerImpl("TEST","testconsumer");
		mockCtr.removeProxyForPullConsumerFromConnectedList(pfpc);
		//pour que l'appel getChannel.getTopic() fonctionne
		EasyMock.expect(mockCtr.getChannel()).andReturn(new Channel("TEST", 1));
		// enregistrement
		EasyMock.replay(mockCtr);

		// lancement du test de la méthode
		pfpc.disconnect();

		// vérification de l'appel à la méthode de suppression
		EasyMock.verify(mockCtr);
		pfpc = null;
	}

	@Test
	public void testPull() throws ChannelNotFoundException,
	NotConnectedException {
		fail("Not yet implemented");
	}


}
