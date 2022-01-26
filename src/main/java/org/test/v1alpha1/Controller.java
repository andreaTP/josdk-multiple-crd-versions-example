 package org.test.v1alpha1;

 import io.fabric8.kubernetes.client.KubernetesClient;
 import io.javaoperatorsdk.operator.api.reconciler.*;
 import org.test.v1alpha1.crd.Example;

 @ControllerConfiguration(namespaces = Constants.WATCH_CURRENT_NAMESPACE, finalizerName = Constants.NO_FINALIZER)
 public class Controller implements Reconciler<Example> {

     private KubernetesClient client;

     public Controller(KubernetesClient client) {
         this.client = client;
     }

     @Override
     public UpdateControl<Example> reconcile(Example example, Context context) {

         System.out.println("Controller v1alpha1:");
         System.out.println("Received Example: " + example);

         return UpdateControl.noUpdate();
     }
 }
