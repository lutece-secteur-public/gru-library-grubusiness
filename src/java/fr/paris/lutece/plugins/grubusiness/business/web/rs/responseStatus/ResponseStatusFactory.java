package fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus;

import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.BAD_REQUEST;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.CONFLICT;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.FAILURE;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.INCOMPLETE_SUCCESS;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.INTERNAL_SERVER_ERROR;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.NOT_FOUND;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.OK;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.SUCCESS;
import static fr.paris.lutece.plugins.grubusiness.business.web.rs.responseStatus.ResponseStatusType.UNAUTHORIZED;

public class ResponseStatusFactory
{

    public static ResponseStatus ok( )
    {
        return new ResponseStatus( 200, OK );
    }

    public static ResponseStatus success( )
    {
        return new ResponseStatus( 201, SUCCESS );
    }

    public static ResponseStatus incompleteSuccess( )
    {
        return new ResponseStatus( 201, INCOMPLETE_SUCCESS );
    }

    public static ResponseStatus badRequest( )
    {
        return new ResponseStatus( 400, BAD_REQUEST );
    }

    public static ResponseStatus unauthorized( )
    {
        return new ResponseStatus( 401, UNAUTHORIZED );
    }

    public static ResponseStatus failure( )
    {
        return new ResponseStatus( 403, FAILURE );
    }

    public static ResponseStatus notFound( )
    {
        return new ResponseStatus( 404, NOT_FOUND );
    }

    public static ResponseStatus conflict( )
    {
        return new ResponseStatus( 409, CONFLICT );
    }

    public static ResponseStatus internalServerError( )
    {
        return new ResponseStatus( 500, INTERNAL_SERVER_ERROR );
    }

    public static ResponseStatus noResult( )
    {
        return new ResponseStatus( 200, NOT_FOUND );
    }

    public static ResponseStatus fromHttpCode( final int httpCode )
    {
        switch( httpCode )
        {
            case 200:
                return ok( );
            case 201:
                return success( );
            case 400:
                return badRequest( );
            case 401:
                return unauthorized( );
            case 403:
                return failure( );
            case 404:
                return notFound( );
            case 409:
                return conflict( );
            default:
                return internalServerError( );
        }
    }
}
