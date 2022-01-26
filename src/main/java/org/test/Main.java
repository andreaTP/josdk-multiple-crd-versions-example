package org.test;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.informers.ResourceEventHandler;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;
import org.test.v2alpha1.crd.ExampleSpec;

public class Main {

    public static void main(String[] args) {
        Config config = new ConfigBuilder().withNamespace(null).build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        Operator operator = new Operator(client, DefaultConfigurationService.instance());
        operator.register(new org.test.v1alpha1.Controller(client));
        operator.register(new org.test.v2alpha1.Controller(client));
        operator.installShutdownHook();
        operator.start();

//        var informer1 = client.genericKubernetesResources(
//                ResourceDefinitionContext.fromResourceType(org.test.v1alpha1.crd.Example.class)
//        ).inNamespace("default").withLabelSelector((String)null).runnableInformer(0);
//
//        informer1.addEventHandler(
//                new ResourceEventHandler<>() {
//                    @Override
//                    public void onAdd(GenericKubernetesResource genericKubernetesResource) {
//                        System.out.println("add 1");
//                    }
//
//                    @Override
//                    public void onUpdate(GenericKubernetesResource genericKubernetesResource, GenericKubernetesResource t1) {
//                        System.out.println("update 1");
//                    }
//
//                    @Override
//                    public void onDelete(GenericKubernetesResource genericKubernetesResource, boolean b) {
//                        System.out.println("delete 1");
//                    }
//                }
//        );
//        informer1.run();
//
//        var informer2 = client.genericKubernetesResources(
//                ResourceDefinitionContext.fromResourceType(org.test.v2alpha1.crd.Example.class)
//        ).inNamespace("default").withLabelSelector((String)null).runnableInformer(0);
//
//        informer2.addEventHandler(
//                new ResourceEventHandler<>() {
//                    @Override
//                    public void onAdd(GenericKubernetesResource genericKubernetesResource) {
//                        System.out.println("add 2");
//                    }
//
//                    @Override
//                    public void onUpdate(GenericKubernetesResource genericKubernetesResource, GenericKubernetesResource t1) {
//                        System.out.println("update 2");
//                    }
//
//                    @Override
//                    public void onDelete(GenericKubernetesResource genericKubernetesResource, boolean b) {
//                        System.out.println("delete 2");
//                    }
//                }
//        );
//        informer2.run();
//
//        client.resources(org.test.v1alpha1.crd.Example.class).list().getItems();
//        client.resources(org.test.v2alpha1.crd.Example.class).list().getItems();
//
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        var x1 = new org.test.v1alpha1.crd.Example();
//        var es1 = new org.test.v1alpha1.crd.ExampleSpec();
//        es1.foo = 1;
//        es1.bar = "bar";
//        x1.setSpec(es1);
//
//        var x2 = new org.test.v2alpha1.crd.Example();
//        var es2 = new org.test.v2alpha1.crd.ExampleSpec();
//        es2.foo = "foo";
//        es2.bar = 123;
//        es2.baz = ExampleSpec.Baz.BAZZZ;
//        x2.setSpec(es2);
//
//        var we1 = new WatchEvent();
//        we1.setObject(x1);
//
//        var we2 = new WatchEvent();
//        we2.setObject(x2);
//
//        var t1 = Serialization.unmarshal(Serialization.asJson(we1), WatchEvent.class);
//        System.out.println(t1.getObject());
//
//        var t2 = Serialization.unmarshal(Serialization.asJson(we2), WatchEvent.class);
//        System.out.println(t2.getObject());
    }
}
