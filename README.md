cougaar-test
============

This is some code to test the Cougaar framework (http://cougaar.org) for
its use in agent-based modeling and simulation.

**PROBLEM:** Blackboard can only be accessed from within the same agent. Global
communication has to be implemented via messages ("relays"?), which seems
overly complex for agent-based simulations...


Setup
-----

Download Cougaar and link to installation directory:

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
