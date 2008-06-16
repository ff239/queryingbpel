package de.uni.stuttgart.bpelSearching.matching;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.log4j.Logger;

import de.uni.stuttgart.gerlacdt.bpel.GraphMapping.nodes.ActivityInvokeNode;
import de.uni.stuttgart.gerlacdt.bpel.GraphMapping.nodes.ActivityNode;
import de.uni.stuttgart.gerlacdt.bpel.GraphMapping.nodes.ActivityReceiveNode;
import de.uni.stuttgart.gerlacdt.bpel.GraphMapping.nodes.ActivityReplyNode;
import de.uni.stuttgart.gerlacdt.bpel.GraphMapping.nodes.StructuredActivityOnMessageNode;


/**
 * The NodeComparator compares two activity nodes.
 * 
 * @author Wei Lu
 * 
 */

public class NodesComparator implements Comparator<ActivityNode> {
	static Logger logger = Logger.getLogger(NodesComparator.class);	
    Pattern pattern = null;
    Matcher matcher = null;
	
	@Override
	public int compare(ActivityNode queryNode, ActivityNode processNode) {
		int queryNodeType, processNodeType;
		String queryNodeName,  queryNodeInputVariableAttr, queryNodeOperationAttr, 
		queryNodeOutputVariableAttr, queryNodeVariableAttr, queryNodePartnerlinkAttr, 
		queryNodePorttypeAttr, processNodeName, processNodeInputVariableAttr, processNodeOperationAttr, 
		processNodeOutputVariableAttr, processNodeVariableAttr, processNodePartnerlinkAttr, processNodePorttypeAttr;

		queryNodeType = queryNode.getActivityType();
		queryNodeName = queryNode.getActivityName();
		
		// If query node type exist, then compare activity type between process/query nodes
		if (queryNodeType != 999) {
			processNodeType = processNode.getActivityType();
			if (queryNodeType != processNodeType) {
				return 1;
			}
		}
		
		
		// If query node name exist, then compare activity type between process/query nodes
		if (queryNodeName.length() > 0) {
			
			processNodeName = processNode.getActivityName();
			if (!patternMatching(queryNodeName, processNodeName)) {
				return 2;				
			}
			
//            try{
//                pattern = Pattern.compile(queryNodeName);
//
//                matcher = pattern.matcher(processNodeName);
//            }
//            catch(PatternSyntaxException pse){
//                logger.warn("There is a problem with the regular expression during the activity name comparison!%n");
//                logger.warn("The pattern in question is: " + pse.getPattern());
//                logger.warn("The description is: " + pse.getDescription());
//                logger.warn("The message is: " + pse.getMessage());
//                logger.warn("The index is: " + pse.getIndex());
//                System.exit(0);
//            }
//			
//            if (!matcher.find()) {
//            	return 2;
//            }			
		}
		
				
		if ((queryNode instanceof ActivityInvokeNode) && (processNode instanceof ActivityInvokeNode)) { 
//		if (queryNode instanceof ActivityInvokeNode) {
//			if (processNode instanceof ActivityInvokeNode) {
			queryNodeInputVariableAttr = ((ActivityInvokeNode)queryNode).getInputVariable();			
			// If query node input variable exist, then compare input variable between process/query nodes
			if (queryNodeInputVariableAttr.length() > 0) {
				processNodeInputVariableAttr = ((ActivityInvokeNode)processNode).getInputVariable();
	            if (!patternMatching(queryNodeInputVariableAttr, processNodeInputVariableAttr)) {
	            	return 2;
	            }			
			}
			
			queryNodeOutputVariableAttr = ((ActivityInvokeNode)queryNode).getOutputVariable();			
			// If query node output variable exist, then compare output variable between process/query nodes
			if (queryNodeOutputVariableAttr.length() > 0) {
				processNodeOutputVariableAttr = ((ActivityInvokeNode)processNode).getOutputVariable();
	            if (!patternMatching(queryNodeOutputVariableAttr, processNodeOutputVariableAttr)) {
	            	return 2;
	            }			
			}
			 			
			queryNodeOperationAttr = ((ActivityInvokeNode)queryNode).getOperation();			
			// If query node operation exist, then compare operation between process/query nodes
			if (queryNodeOperationAttr.length() > 0) {
				processNodeOperationAttr = ((ActivityInvokeNode)processNode).getOperation();
		        if (!patternMatching(queryNodeOperationAttr, processNodeOperationAttr)) {
		           return 2;
		         }			
			}
			
			queryNodePorttypeAttr = ((ActivityInvokeNode)queryNode).getPortType().toString();			
			// If query node porttype exist, then compare porttype between process/query nodes
			if (queryNodePorttypeAttr.length() > 0) {
				processNodePorttypeAttr = ((ActivityInvokeNode)processNode).getPortType().toString();
	            if (!patternMatching(queryNodePorttypeAttr, processNodePorttypeAttr)) {
	            	return 2;
	            }			
			}
						
			queryNodePartnerlinkAttr = ((ActivityInvokeNode)queryNode).getPartnerLink();			
			// If query node partnerlink exist, then compare partnerlinks between process/query nodes
			if (queryNodePartnerlinkAttr.length() > 0) {
				processNodePartnerlinkAttr = ((ActivityInvokeNode)processNode).getPartnerLink();
	            if (!patternMatching(queryNodePartnerlinkAttr, processNodePartnerlinkAttr)) {
	            	return 2;
	            }			
			}	
		}
		
		
		if ((queryNode instanceof ActivityReceiveNode) && (processNode instanceof ActivityReceiveNode)) { 			
			queryNodeVariableAttr = ((ActivityReceiveNode)queryNode).getVariable();			
			// If query node variable exist, then compare variable between process/query nodes
			if (queryNodeVariableAttr.length() > 0) {
				processNodeVariableAttr = ((ActivityReceiveNode)processNode).getVariable();
	            if (!patternMatching(queryNodeVariableAttr, processNodeVariableAttr)) {
	            	return 2;
	            }			
			}
						 			
			queryNodeOperationAttr = ((ActivityReceiveNode)queryNode).getOperation();			
			// If query node operation exist, then compare operation between process/query nodes
			if (queryNodeOperationAttr.length() > 0) {
				processNodeOperationAttr = ((ActivityReceiveNode)processNode).getOperation();
		        if (!patternMatching(queryNodeOperationAttr, processNodeOperationAttr)) {
		           return 2;
		         }			
			}
			
			queryNodePorttypeAttr = ((ActivityReceiveNode)queryNode).getPortType().toString();			
			// If query node porttype exist, then compare porttypes between process/query nodes
			if (queryNodePorttypeAttr.length() > 0) {
				processNodePorttypeAttr = ((ActivityReceiveNode)processNode).getPortType().toString();
	            if (!patternMatching(queryNodePorttypeAttr, processNodePorttypeAttr)) {
	            	return 2;
	            }			
			}			
			
			queryNodePartnerlinkAttr = ((ActivityReceiveNode)queryNode).getPartnerLink();			
			// If query node partnerlink exist, then compare partnerlinks between process/query nodes
			if (queryNodePartnerlinkAttr.length() > 0) {
				processNodePartnerlinkAttr = ((ActivityReceiveNode)processNode).getPartnerLink();
	            if (!patternMatching(queryNodePartnerlinkAttr, processNodePartnerlinkAttr)) {
	            	return 2;
	            }			
			}						
		}
		
		if ((queryNode instanceof ActivityReplyNode) && (processNode instanceof ActivityReplyNode)) { 			
			queryNodeVariableAttr = ((ActivityReplyNode)queryNode).getVariable();			
			// If query node variable exist, then compare variable between process/query nodes
			if (queryNodeVariableAttr.length() > 0) {
				processNodeVariableAttr = ((ActivityReplyNode)processNode).getVariable();
	            if (!patternMatching(queryNodeVariableAttr, processNodeVariableAttr)) {
	            	return 2;
	            }			
			}
						 			
			queryNodeOperationAttr = ((ActivityReplyNode)queryNode).getOperation();			
			// If query node operation exist, then compare operation between process/query nodes
			if (queryNodeOperationAttr.length() > 0) {
				processNodeOperationAttr = ((ActivityReplyNode)processNode).getOperation();
		        if (!patternMatching(queryNodeOperationAttr, processNodeOperationAttr)) {
		           return 2;
		         }			
			}
			
			queryNodePorttypeAttr = ((ActivityReplyNode)queryNode).getPortType().toString();			
			// If query node porttype exist, then compare porttypes between process/query nodes
			if (queryNodePorttypeAttr.length() > 0) {
				processNodePorttypeAttr = ((ActivityReplyNode)processNode).getPortType().toString();
	            if (!patternMatching(queryNodePorttypeAttr, processNodePorttypeAttr)) {
	            	return 2;
	            }			
			}			
			
			queryNodePartnerlinkAttr = ((ActivityReplyNode)queryNode).getPartnerLink();			
			// If query node partnerlink exist, then compare partnerlinks between process/query nodes
			if (queryNodePartnerlinkAttr.length() > 0) {
				processNodePartnerlinkAttr = ((ActivityReplyNode)processNode).getPartnerLink();
	            if (!patternMatching(queryNodePartnerlinkAttr, processNodePartnerlinkAttr)) {
	            	return 2;
	            }			
			}						
		}
		
		
		if ((queryNode instanceof StructuredActivityOnMessageNode) && (processNode instanceof StructuredActivityOnMessageNode)) { 			
			queryNodeVariableAttr = ((StructuredActivityOnMessageNode)queryNode).getVariable();			
			// If query node variable exist, then compare variable between process/query nodes
			if (queryNodeVariableAttr.length() > 0) {
				processNodeVariableAttr = ((StructuredActivityOnMessageNode)processNode).getVariable();
	            if (!patternMatching(queryNodeVariableAttr, processNodeVariableAttr)) {
	            	return 2;
	            }			
			}
						 			
			queryNodeOperationAttr = ((StructuredActivityOnMessageNode)queryNode).getOperation();			
			// If query node operation exist, then compare operation between process/query nodes
			if (queryNodeOperationAttr.length() > 0) {
				processNodeOperationAttr = ((StructuredActivityOnMessageNode)processNode).getOperation();
		        if (!patternMatching(queryNodeOperationAttr, processNodeOperationAttr)) {
		           return 2;
		         }			
			}
			
			queryNodePorttypeAttr = ((StructuredActivityOnMessageNode)queryNode).getPortType().toString();			
			// If query node porttype exist, then compare porttypes between process/query nodes
			if (queryNodePorttypeAttr.length() > 0) {
				processNodePorttypeAttr = ((StructuredActivityOnMessageNode)processNode).getPortType().toString();
	            if (!patternMatching(queryNodePorttypeAttr, processNodePorttypeAttr)) {
	            	return 2;
	            }			
			}			
			
			queryNodePartnerlinkAttr = ((StructuredActivityOnMessageNode)queryNode).getPartnerLink();			
			// If query node partnerlink exist, then compare partnerlinks between process/query nodes
			if (queryNodePartnerlinkAttr.length() > 0) {
				processNodePartnerlinkAttr = ((StructuredActivityOnMessageNode)processNode).getPartnerLink();
	            if (!patternMatching(queryNodePartnerlinkAttr, processNodePartnerlinkAttr)) {
	            	return 2;
	            }			
			}						
		}
				
		return 0;
	}
	
	
	
    /**
     * Compare two strings by using java regular expression.
     *
     * @param p a regular expression, specified as a string.
     * @param m a string to be checked, if it matches <code>p</code>.
     * 
     * @return <code>true</code> if <code>m</code> matches <code>p</code>, otherwise <code>false</code>.
     */
	
	private boolean patternMatching(String p, String m) {
        try{
            pattern = Pattern.compile(p, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(m);
        }
        catch(PatternSyntaxException pse){
            logger.warn("There is a problem with the regular expression during the activity name comparison!%n");
            logger.warn("The pattern in question is: " + pse.getPattern());
            logger.warn("The description is: " + pse.getDescription());
            logger.warn("The message is: " + pse.getMessage());
            logger.warn("The index is: " + pse.getIndex());
            System.exit(0);
        }
		
		return matcher.find();
	}

}