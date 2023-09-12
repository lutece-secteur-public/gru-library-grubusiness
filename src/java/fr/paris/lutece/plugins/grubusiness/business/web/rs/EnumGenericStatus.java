package fr.paris.lutece.plugins.grubusiness.business.web.rs;


public enum EnumGenericStatus
{
    TERMINE(15,"grustoragedb.enum.generic_status.label.termine"),
    ACQUITTE(14,"grustoragedb.enum.generic_status.label.acquitte"),
    ACOMPLETER(13,"grustoragedb.enum.generic_status.label.a_completer"),
    AREGLER(12,"grustoragedb.enum.generic_status.label.a_regler"),
    ENCOURS(11,"grustoragedb.enum.generic_status.label.en_cours"),
    ANNULE(10,"grustoragedb.enum.generic_status.label.annule");
    
    
    private Integer _nStatusId;
    private String _strLabel;
    
    /**
     * Private constructor
     * @param nStatusId
     * @param strLabelle
     */
    private EnumGenericStatus( Integer nStatusId, String strLabel )
    {
        _nStatusId = nStatusId;
        _strLabel = strLabel;
    }

    /**
     * @return the _nStatusId
     */
    public Integer getStatusId( )
    {
        return _nStatusId;
    }

    /**
     * @return the _strLabel
     */
    public String getLabel( )
    {
        return _strLabel;
    }
    
    /**
     * Check if id status exist
     * @param nIdStatus
     * @return true if exist
     */
    public static boolean existStatus ( Integer nIdStatus )
    {
        for ( EnumGenericStatus status : EnumGenericStatus.values( ) )
        {
            if( status.getStatusId( ).equals( nIdStatus ) )
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return EnumGenericStatus by id status
     * @param nIdStatus
     * @return enumGenericStatus
     */
    public static EnumGenericStatus getByStatusId ( Integer nIdStatus )
    {
        for ( EnumGenericStatus status : EnumGenericStatus.values( ) )
        {
            if( status.getStatusId( ).equals( nIdStatus ) )
            {
                return status;
            }
        }
        return null;
    }
    
    /**
     * Return true if id status is an closed status
     * @param nIdStatus
     * @return true if id status is an closed status
     */
    public static boolean isClosedStatus ( Integer nIdStatus )
    {
        return EnumGenericStatus.TERMINE.getStatusId( ).equals( nIdStatus ) || EnumGenericStatus.ANNULE.getStatusId( ).equals( nIdStatus )
                || EnumGenericStatus.ACQUITTE.getStatusId( ).equals( nIdStatus ) ;
    }
}