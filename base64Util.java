package kr.go.ePrivacy.connection.accept.cypher ;

import java.io.ByteArrayOutputStream ;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

public class base64Util
{
	/**
	 * Base64Encoding 방식으로 바이트 배열을 아스키 문자열로 인코딩한다. In-Binany, Out-Ascii
	 * 
	 * @param encodeBytes
	 *            인코딩할 바이트 배열(byte[])
	 * @return 인코딩된 아스키 문자열(String)
	 */
	
	public static String encode ( byte [ ] encodeBytes )
	{
		byte [ ] buf = null ;
		String strResult = null ;

		Base64 base64Encoder = new Base64 ( ) ;
		//ByteArrayInputStream bin = new ByteArrayInputStream ( encodeBytes ) ;
		ByteArrayOutputStream bout = new ByteArrayOutputStream ( ) ;

		try
		{
			base64Encoder.encode ( encodeBytes ) ;
		}
		catch ( Exception e )
		{
			return strResult ;
		}
		buf = bout.toByteArray ( ) ;
		strResult = new String ( buf ).trim ( ) ;
		return strResult ;
	}

	/**
	 * Base64Decoding 방식으로 아스키 문자열을 바이트 배열로 디코딩한다. In-Ascii, Out-Binany
	 * 
	 * @param strDecode
	 *            디코딩할 아스키 문자열(String)
	 * @return 디코딩된 바이트 배열(byte[])
	 */
	public static byte [ ] decode ( String strDecode )
	{
		byte [ ] buf = null ;

		Base64 base64Decoder = new Base64 ( ) ;
		//ByteArrayInputStream bin = new ByteArrayInputStream ( strDecode.getBytes ( ) ) ;
		ByteArrayOutputStream bout = new ByteArrayOutputStream ( ) ;

		try
		{
			base64Decoder.decode ( strDecode ) ;
		}
		catch ( Exception e )
		{
			buf = null;
		}
		
		buf = bout.toByteArray ( ) ;
		return buf ;
	}

	/**
	 * Base64Decoding 방식으로 아스키 문자열을 바이트 배열로 디코딩한 후 문자열을 생성해서 반환한다.
	 * In-Ascii, Out-Binany
	 * @param strDecode  디코딩할 아스키 문자열(String)
	 * @return 디코딩된 바이트 배열(byte[])
	 */
	public static String getBase64DecodedString ( String strDecode )
	{
		if ( strDecode == null || "".equals ( strDecode ) )
		{
			return "" ;
		}
		else
		{
			return new String ( decode ( strDecode ) ) ;
		}
	}

	/**
	 * Base64Decoding 방식으로 아스키 문자열을 바이트 배열로 디코딩한 후
	 * 요청하는 인코딩으로 문자열을 생성해서 반환한다.
	 * In-Ascii, Out-Binany
	 * @param strDecode  디코딩할 아스키 문자열(String)
	 * @return 디코딩된 바이트 배열(byte[])
	 */
	public static String getBase64DecodedString ( String strDecode , String strCharSet )
	{
		if ( strDecode == null || "".equals ( strDecode ) || strCharSet == null || "".equals ( strCharSet ) )
		{
			return "" ;
		}
		else
		{
			try
			{
				return new String ( decode ( strDecode ) , strCharSet ) ;
			}
			catch ( IOException e )
			{
				return "" ;
			}			
			catch ( Exception e )
			{
				return "" ;
			}
			finally
			{}
		}
	}
}
