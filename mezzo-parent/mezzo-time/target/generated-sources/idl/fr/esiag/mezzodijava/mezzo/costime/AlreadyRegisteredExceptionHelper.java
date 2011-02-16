package fr.esiag.mezzodijava.mezzo.costime;


/**
 * Generated from IDL exception "AlreadyRegisteredException".
 *
 * @author JacORB IDL compiler V 2.3.1 (JBoss patch01), 29-Jul-2009
 * @version generated at 16 f�vr. 2011 00:48:13
 */

public final class AlreadyRegisteredExceptionHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_exception_tc(fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredExceptionHelper.id(),"AlreadyRegisteredException",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("message", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:costime/AlreadyRegisteredException:1.0";
	}
	public static fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException read (final org.omg.CORBA.portable.InputStream in)
	{
		String id = in.read_string();
		if (!id.equals(id())) throw new org.omg.CORBA.MARSHAL("wrong id: " + id);
		java.lang.String x0;
		x0=in.read_string();
		final fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException result = new fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException(id, x0);
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final fr.esiag.mezzodijava.mezzo.costime.AlreadyRegisteredException s)
	{
		out.write_string(id());
		out.write_string(s.message);
	}
}
