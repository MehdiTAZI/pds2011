package CosEvent;


/**
* CosEvent/ProxyPushConsumerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from prototype.idl
* samedi 27 novembre 2010 15 h 07 CET
*/

abstract public class ProxyPushConsumerHelper
{
  private static String  _id = "IDL:CosEvent/ProxyPushConsumer:1.0";

  public static void insert (org.omg.CORBA.Any a, CosEvent.ProxyPushConsumer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CosEvent.ProxyPushConsumer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CosEvent.ProxyPushConsumerHelper.id (), "ProxyPushConsumer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CosEvent.ProxyPushConsumer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ProxyPushConsumerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CosEvent.ProxyPushConsumer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CosEvent.ProxyPushConsumer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CosEvent.ProxyPushConsumer)
      return (CosEvent.ProxyPushConsumer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CosEvent._ProxyPushConsumerStub stub = new CosEvent._ProxyPushConsumerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CosEvent.ProxyPushConsumer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CosEvent.ProxyPushConsumer)
      return (CosEvent.ProxyPushConsumer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CosEvent._ProxyPushConsumerStub stub = new CosEvent._ProxyPushConsumerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
