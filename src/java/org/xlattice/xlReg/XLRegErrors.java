/* XLRegErrors.java */
package org.xlattice.xlReg;

public class XLRegErrors {

	public final int BAD_ATTRS_LINE = -1;
	public final int BAD_VERSION = -2;
	public final int CANT_FIND_CLUSTER_BY_ID = -3;
	public final int CANT_FIND_CLUSTER_BY_NAME = -4;
	public final int CLUSTER_MEMBER_ID_IN_USE = -5;
	public final int CLUSTER_MEMBERS_MUST_HAVE_END_POINT = -6;
	public final int CLUSTER_MEMBER_NAME_IN_USE = -7;
	public final int CLUSTER_MUST_HAVE_MEMBER = -8;
	public final int CLUSTER_MUST_HAVE_TWO = -9;
	public final int ID_ALREADY_IN_USE = -10;
	public final int ILL_FORMED_CLUSTER = -11;
	public final int ILL_FORMED_CLUSTER_MEMBER = -12;
	public final int ILL_FORMED_REG_CRED = -13;
	public final int MEMBER_MUST_HAVE_END_POINT = -14;
	public final int MISSING_CLOSING_BRACE = -15;
	public final int MISSING_CLUSTER_NAME_OR_ID = -16;
	public final int MISSING_END_POINTS_SECTION = -17;
	public final int MISSING_MEMBERS_LIST = -18;
	public final int MISSING_NODE = -19;
	public final int MISSING_PRIVATE_KEY = -20;
	public final int MISSING_REG_NODE_LINE = -21;
	public final int MISSING_SERVER_INFO = -22;
	public final int NAME_ALREADY_IN_USE = -23;
	public final int NIL_CLUSTER = -24;
	public final int NIL_CLUSTER_MEMBER = -25;
	public final int NIL_NODE = -26;
	public final int NIL_PRIVATE_KEY = -27;
	public final int NIL_REGISTRY = -28;
	public final int NIL_REG_NODE = -29;
	public final int NIL_TOKEN = -30;
	public final int RCVD_INVALID_MSG_FOR_STATE = -31;
	public final int TAG_OUT_OF_RANGE = -32;
	public final int UNEXPECTED_MSG_TYPE = -33;
	public final int WRONG_NUMBER_OF_BYTES_IN_ATTRS = -34;

	public final String[] ERRORS = {
		"badly formed attrs line",
		"badly formated VERSION",
		"cannot find cluster with this ID",
		"cannot find cluster with this name",
		"cluster member id already in use",
		"cluster members must have at least one endPoint",
		"cluster member name already in use",
		"cluster must have a member!",
		"cluster must have at least two members",
		"ID already in use",
		"ill-formed cluster serialization",
		"ill-formed cluster member serialization",
		"ill-formed regCred serialization",
		"member must have at least one endPoint",
		"missing closing brace",
		"missing cluster name or ID",
		"missing endPoints section",
		"missing members list",
		"missing node parameter",
		"missing private key line",
		"missing regNode line",
		"missing server info",
		"name already in use",
		"nil cluster argument",
		"nil cluster member argument",
		"nil node argument",
		"nil private key argument",
		"nil registry argument",
		"nil RegNode argument",
		"nil XLRegMsg_Token argument",
		"invalid msg type for current state",
		"message tag out of range",
		"unexpected message type",
		"wrong number of bytes in attrs",
	};
}
