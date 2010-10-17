package InterfaceIDL;


/**
* InterfaceIDL/ImprimanteHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Imprimante.idl
* mercredi 6 octobre 2010 13 h 35 CEST
*/

abstract public class ImprimanteHelper
{
  private static String  _id = "IDL:InterfaceIDL/Imprimante:1.0";

  public static void insert (org.omg.CORBA.Any a, InterfaceIDL.Imprimante that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static InterfaceIDL.Imprimante extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (InterfaceIDL.ImprimanteHelper.id (), "Imprimante");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static InterfaceIDL.Imprimante read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ImprimanteStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, InterfaceIDL.Imprimante value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static InterfaceIDL.Imprimante narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof InterfaceIDL.Imprimante)
      return (InterfaceIDL.Imprimante)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      InterfaceIDL._ImprimanteStub stub = new InterfaceIDL._ImprimanteStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static InterfaceIDL.Imprimante unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof InterfaceIDL.Imprimante)
      return (InterfaceIDL.Imprimante)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      InterfaceIDL._ImprimanteStub stub = new InterfaceIDL._ImprimanteStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
