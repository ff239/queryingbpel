/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.open.oasis.docs.wsbpel._2._0.process.executable;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getImportType <em>Import Type</em>}</li>
 *   <li>{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getLocation <em>Location</em>}</li>
 *   <li>{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.open.oasis.docs.wsbpel._2._0.process.executable.ExecutablePackage#getImport()
 * @model extendedMetaData="name='tImport' kind='elementOnly'"
 * @generated
 */
public interface Import extends ExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Import Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Type</em>' attribute.
	 * @see #setImportType(String)
	 * @see org.open.oasis.docs.wsbpel._2._0.process.executable.ExecutablePackage#getImport_ImportType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
	 *        extendedMetaData="kind='attribute' name='importType'"
	 * @generated
	 */
	String getImportType();

	/**
	 * Sets the value of the '{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getImportType <em>Import Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Type</em>' attribute.
	 * @see #getImportType()
	 * @generated
	 */
	void setImportType(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.open.oasis.docs.wsbpel._2._0.process.executable.ExecutablePackage#getImport_Location()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='location'"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.open.oasis.docs.wsbpel._2._0.process.executable.ExecutablePackage#getImport_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='namespace'"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.open.oasis.docs.wsbpel._2._0.process.executable.Import#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

} // Import
