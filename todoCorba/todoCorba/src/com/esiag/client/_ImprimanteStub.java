package com.esiag.client;


/**
* InterfaceIDL/_ImprimanteStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Imprimante.idl
* mercredi 6 octobre 2010 13 h 35 CEST
*/

public class _ImprimanteStub extends org.omg.CORBA.portable.ObjectImpl implements Imprimante
{

  public void getInfo (org.omg.CORBA.StringHolder imprimante, org.omg.CORBA.StringHolder serveur, org.omg.CORBA.StringHolder hostname, org.omg.CORBA.ShortHolder tacheEnCours)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getInfo", true);
                $in = _invoke ($out);
                imprimante.value = $in.read_string ();
                serveur.value = $in.read_string ();
                hostname.value = $in.read_string ();
                tacheEnCours.value = $in.read_short ();
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getInfo (imprimante, serveur, hostname, tacheEnCours        );
            } finally {
                _releaseReply ($in);
            }
  } // getInfo

  public short printDocument (String nomFichier, org.omg.CORBA.IntHolder nbOctets) throws TacheRefusee
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("printDocument", true);
                $out.write_string (nomFichier);
                $in = _invoke ($out);
                short $result = $in.read_short ();
                nbOctets.value = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:InterfaceIDL/TacheRefusee:1.0"))
                    throw TacheRefuseeHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return printDocument (nomFichier, nbOctets        );
            } finally {
                _releaseReply ($in);
            }
  } // printDocument

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:InterfaceIDL/Imprimante:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _ImprimanteStub
