
Run this example:

```
mvn clean compile
```

Install the CRD:

```
kubectl apply -f target/classes/META-INF/fabric8/examples.org.example-v1.yml
```

Run the operator:

```
mvn clean compile exec:java
```

And play with the CRs:

```
kubectl apply -f src/main/resources/example-v1alpha1.yaml
kubectl delete -f src/main/resources/example-v1alpha1.yaml
kubectl apply -f src/main/resources/example-v2alpha1.yaml
kubectl delete -f src/main/resources/example-v2alpha1.yaml
```
