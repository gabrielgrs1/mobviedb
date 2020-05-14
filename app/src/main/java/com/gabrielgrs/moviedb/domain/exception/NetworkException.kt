package com.gabrielgrs.moviedb.domain.exception

import com.gabrielgrs.moviedb.R
import com.gabrielgrs.moviedb.core.helper.Resources

class NetworkException :
    GenericException(Resources.resourceHelper.getString(R.string.generic_network_error))