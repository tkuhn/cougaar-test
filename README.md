cougaar-test
============

This is some code to test the Cougaar framework (http://cougaar.org).


Setup
-----

Link to Cougaar installation:

    $ ln -s /path/to/cougaar/cougaar cougaar

Set environment variables:

    $ export COUGAAR_SOCIETY_PATH=`pwd`
    $ export COUGAAR_INSTALL_PATH=$COUGAAR_SOCIETY_PATH/cougaar
    $ export COUGAAR_RUNTIME_PATH=$COUGAAR_SOCIETY_PATH/run


Running
-------

Compile:

    $ ant

Run:

    $ cd $COUGAAR_RUNTIME_PATH
    $ $COUGAAR_INSTALL_PATH/bin/cougaar ../configs/Test.xml SingleNodeRuntime.xml
