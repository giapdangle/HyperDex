package org.hyperdex.client;

import java.util.*;
import java.io.UnsupportedEncodingException;

public class ByteArraySortedSet extends TreeSet<ByteArray>
{
    private String defaultEncoding = "UTF-8";

    public ByteArraySortedSet()
    {
        super();
    }

    public ByteArraySortedSet(String defaultEncoding)
    {
        super();
        this.defaultEncoding = defaultEncoding;
    }

    private Object getByteArrayObjectFromObject(Object o)
    {
        
        try
        {
		    if ( o instanceof byte[] )
		    {
		        return new ByteArray((byte[])o);
		    }
		    else if ( o instanceof ByteArray )
		    {
		        return (ByteArray)o;
		    }
		    else if ( o instanceof String )
		    {
		        return new ByteArray((String)o,defaultEncoding);
		    }
	        else
	        {
	            return o;
	        }
        }
        catch(TypeError e)
        {
            return o;
        }
    }

    public void add(byte[] elementBytes)
    {
        super.add(new ByteArray(elementBytes));
    }

    public void add(String elementStr) throws TypeError
    {
        super.add(new ByteArray(elementStr,defaultEncoding));
    }

    public boolean contains(Object element)
    {
        return super.contains(getByteArrayObjectFromObject(element));
    }
}
