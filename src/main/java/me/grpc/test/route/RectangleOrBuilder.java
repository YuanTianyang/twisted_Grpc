// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rectangle.proto

package me.grpc.test.route;

public interface RectangleOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Rectangle)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.Point lo = 1;</code>
   */
  boolean hasLo();
  /**
   * <code>.Point lo = 1;</code>
   */
  me.grpc.test.route.Point getLo();
  /**
   * <code>.Point lo = 1;</code>
   */
  me.grpc.test.route.PointOrBuilder getLoOrBuilder();

  /**
   * <code>.Point hi = 2;</code>
   */
  boolean hasHi();
  /**
   * <code>.Point hi = 2;</code>
   */
  me.grpc.test.route.Point getHi();
  /**
   * <code>.Point hi = 2;</code>
   */
  me.grpc.test.route.PointOrBuilder getHiOrBuilder();
}
