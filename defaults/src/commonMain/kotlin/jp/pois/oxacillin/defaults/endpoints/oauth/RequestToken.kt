/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2020 StarryBlueSky
 *     Copyright (c) 2021 poispois
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@file:Suppress("UNUSED", "NOTHING_TO_INLINE")

package jp.pois.oxacillin.defaults.endpoints.oauth

import jp.pois.oxacillin.defaults.endpoints.OAuth
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.oauth
import jp.pois.oxacillin.endpoints.oauth.RequestTokenResponse
import jp.pois.oxacillin.endpoints.oauth.requestToken

/**
 * Allows a Consumer application to obtain an OAuth Request Token to request user authorization. This method fulfills Section 6.1 of the OAuth 1.0 authentication flow.
 * We require you use HTTPS for all OAuth authorization steps.
 * Usage Note: Only ASCII values are accepted for the oauth_nonce
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/basics/authentication/api-reference/request_token)
 * 
 * @param callbackUrl For OAuth 1.0a compliance this parameter is required . The value you specify here will be used as the URL a user is redirected to should they approve your application's access to their account. Set this to oob for out-of-band pin mode. This is also how you specify custom callbacks for use in desktop/mobile applications. Always send an oauth_callback on this step, regardless of a pre-registered callback. We require that any callback URL used with this endpoint will have to be whitelisted within the app settings on developer.twitter.com*
 * @param xAuthAccessType Overrides the access level an application requests to a users account. Supported values are read or write . This parameter is intended to allow a developer to register a read/write application but also request read only access when appropriate.
 * @param options Optional. Custom parameters of this request.
 * @receiver [OAuth] endpoint instance.
 * @return [RequestTokenResponse].
 */
public suspend inline fun OAuth.requestToken(
    callbackUrl: String = "oob",
    xAuthAccessType: String? = null,
    vararg options: Option
): RequestTokenResponse = client.oauth.requestToken(callbackUrl, xAuthAccessType, *options)
