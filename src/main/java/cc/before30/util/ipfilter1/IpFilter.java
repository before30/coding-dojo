package cc.before30.util.ipfilter1;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by before30 on 24/12/2016.
 */
public class IpFilter {
    private Node root = new Node();

    public boolean add(String ipAddress){
        List<Integer> ipNumbers = splitIpAddress(ipAddress);
        if (ipNumbers.size() != 4){
            return false;
        }

        root.add(ipNumbers);
        return true;
    }

    public boolean contains(String ipAddress){
        List<Integer> ipNumbers = splitIpAddress(ipAddress);
        if (ipNumbers.size() != 4){
            return false;
        }

        return root.contains(ipNumbers);
    }

    public boolean containsWithForLoop(String ipAddress){
        List<Integer> ipNumbers = splitIpAddress(ipAddress);
        if (ipNumbers.size() != 4) {
            return false;
        }

        Node node = root;
        for (int ipNum : ipNumbers){
            Node tmpNode = node.get(ipNum);
            if (tmpNode == null){
                tmpNode = node.get(Node.STAR_VALUE);
                if (tmpNode == null){
                    return false;
                }
            }

            node = tmpNode;
        }

        return true;
    }

    private List<Integer> splitIpAddress(String ipAddress){

        ArrayList<Integer> ipNumberList = new ArrayList<Integer>();

        if (StringUtils.isEmpty(ipAddress)){
            return ipNumberList;
        }

        String[] ipNumbers = StringUtils.split(ipAddress, "\\.");
        if (ipNumbers.length != 4){
            return ipNumberList;
        }


        for(String ipNumber : ipNumbers){
            if (StringUtils.isNumeric(ipNumber)){
                int ipNum = Integer.parseInt(ipNumber);
                if (ipNum < 0 || ipNum >= 255){
                    break;
                }
                ipNumberList.add(ipNum);
            } else if (StringUtils.equals("*", ipNumber)){
                ipNumberList.add(Node.STAR_VALUE);
            } else {
                break;
            }
        }

        return ipNumberList;
    }

    public void printAll(){
        root.printAll();
    }

}
