class AlterStaff < ActiveRecord::Migration[5.0]
  def change
    add_column :staffs, :active, :boolean
  end
end
