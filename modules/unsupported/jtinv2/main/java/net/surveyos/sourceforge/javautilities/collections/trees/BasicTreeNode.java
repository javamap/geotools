/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2011, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */

package net.surveyos.sourceforge.javautilities.collections.trees;

import java.util.LinkedList;
import java.util.List;

public class BasicTreeNode<E> implements TreeNode<E> 
{
	private int identifier;
	private int level;
	private TreeNode<E> parentNode;
	private LinkedList<TreeNode<E>> childNodes;
	private E value;
	private boolean isRootNode;
	private boolean isLeafNode;
	
	public BasicTreeNode(int argIdentifier, int argLevel, TreeNode<E> argParentNode, 
			List<TreeNode<E>> argChildren, E argValue, boolean argIsRootNode, boolean argIsLeafNode)
	{
		this.identifier = argIdentifier;
		this.level = argLevel;
		this.parentNode = argParentNode;
		this.childNodes = new LinkedList<TreeNode<E>>();
		
		// Add the children if needed.
		if(argChildren != null)
		{
			this.childNodes.addAll(argChildren);
		}
		
		this.value = argValue;
		this.isRootNode = argIsRootNode;
		this.isLeafNode = argIsLeafNode;
	}

	@Override
	public int getIdentifier() 
	{
		return this.identifier;
	}

	@Override
	public int getLevel() 
	{
		return this.level;
	}

	@Override
	public TreeNode<E> getParent() 
	{
		return this.parentNode;
	}

	@Override
	public List<TreeNode<E>> getChildren()
	{
		return this.childNodes;
	}

	@Override
	public E getValue() 
	{
		return this.value;
	}

	public boolean isRootNode()
	{
		return this.isRootNode;
	}
	
	public void addChildNode(TreeNode<E> argChildNode)
	{
		if(this.childNodes == null)
		{
			this.childNodes = new LinkedList<TreeNode<E>>();
		}
		
		this.childNodes.add(argChildNode);
	}

	@Override
	public boolean isLeafNode() 
	{
		return this.isLeafNode;
	}
}
