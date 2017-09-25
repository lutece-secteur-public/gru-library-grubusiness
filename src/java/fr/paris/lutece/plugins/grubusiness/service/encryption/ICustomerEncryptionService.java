/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.grubusiness.service.encryption;

import fr.paris.lutece.plugins.grubusiness.business.customer.Customer;
import fr.paris.lutece.plugins.grubusiness.business.demand.Demand;

/**
 * This interface enables to encrypt / decrypt a {@code Customer}
 *
 */
public interface ICustomerEncryptionService
{
    /**
     * <p>
     * Encrypts a {@link Customer} from the specified {@code Customer}.
     * <p>
     * <p>
     * The provided {@code Customer} is not modified.
     * </p>
     * 
     * @param customer
     *            the customer from which the {@code Customer} is encrypted. Must not be {@code null}
     * @param demand
     *            the demand for which the {@code Customer} is encrypted. Must not be {@code null}
     * @return the encrypted {@code Customer}
     */
    Customer encrypt( Customer customer, Demand demand );

    /**
     * <p>
     * Encrypts a {@link Customer} from the specified {@code Customer}.
     * <p>
     * <p>
     * The provided {@code Customer} is not modified.
     * </p>
     * 
     * @param customer
     *            the customer from which the {@code Customer} is encrypted. Must not be {@code null}
     * @param strCode
     *            the code used to encrypt the {@code Customer}. Must not be {@code null}
     * @return the encrypted {@code Customer}
     */
    Customer encrypt( Customer customer, String strCode );

    /**
     * <p>
     * Decrypts a {@link Customer} from the specified {@code Customer}.
     * <p>
     * <p>
     * The provided {@code Customer} is not modified.
     * </p>
     * 
     * @param customer
     *            the customer from which the {@code Customer} is decrypted. Must not be {@code null}
     * @param demand
     *            the demand for which the {@code Customer} is decrypted. Must not be {@code null}
     * @return the decrypted {@code Customer}
     */
    Customer decrypt( Customer customer, Demand demand );

    /**
     * <p>
     * Decrypts a {@link Customer} from the specified {@code Customer}.
     * <p>
     * <p>
     * The provided {@code Customer} is not modified.
     * </p>
     * 
     * @param customer
     *            the customer from which the {@code Customer} is decrypted. Must not be {@code null}
     * @param strCode
     *            the code used to decrypt the {@code Customer}. Must not be {@code null}
     * @return the decrypted {@code Customer}
     */
    Customer decrypt( Customer customer, String strCode );
}
